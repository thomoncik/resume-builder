package com.github.thomoncik.resumebuilder.sections;

import com.github.thomoncik.resumebuilder.sections.grading.GradingScale;
import com.github.thomoncik.resumebuilder.sections.grading.LevelScale;
import com.github.thomoncik.resumebuilder.sections.grading.NumberScale;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AccessibleSkillsTest {

    @Test
    void canNotProcessBothNull() {
        AccessibleSkills accessibleSkills = new AccessibleSkills(null, null);
        assertNull(accessibleSkills.process());
    }

    @Test
    void canNotProcessNullSkills() {
        AccessibleSkills accessibleSkills = new AccessibleSkills(new LevelScale(), new ArrayList<>());
        assertNull(accessibleSkills.process());
        accessibleSkills = new AccessibleSkills(new NumberScale(), new ArrayList<>());
        assertNull(accessibleSkills.process());
    }

    @Test
    void canNotProcessNullScale() {
        ArrayList<AccessibleSkills.Skill> skills = new ArrayList<>();
        skills.add(new AccessibleSkills.Skill());
        AccessibleSkills accessibleSkills = new AccessibleSkills(null, skills);
        assertNull(accessibleSkills.process());
    }

    @Test
    void emptyFieldsLevel() {
        ArrayList<AccessibleSkills.Skill> skills = new ArrayList<>();
        skills.add(new AccessibleSkills.Skill());
        AccessibleSkills accessibleSkills = new AccessibleSkills(new LevelScale(), skills);
        assertEquals(beginning() +
                "\\begin{tabular}{ @{} >{\\bfseries}l @{\\hspace{6ex}} l }\n" +
                "\\end{tabular}\n" +
                ending(), accessibleSkills.process().toString());
    }

    @Test
    void emptyFieldsNumber() {
        ArrayList<AccessibleSkills.Skill> skills = new ArrayList<>();
        skills.add(new AccessibleSkills.Skill());
        AccessibleSkills accessibleSkills = new AccessibleSkills(new NumberScale(), skills);
        assertEquals(beginning() +
                ending(), accessibleSkills.process().toString());
    }

    @Test
    void allFieldsLevel() {
        ArrayList<AccessibleSkills.Skill> skills = new ArrayList<>();
        AccessibleSkills.Skill skill = new AccessibleSkills.Skill();
        skill.name = "Git";
        skill.level = GradingScale.Level.FIVE;
        skills.add(skill);
        AccessibleSkills accessibleSkills = new AccessibleSkills(new LevelScale(), skills);
        assertEquals(beginning() +
                "\\begin{tabular}{ @{} >{\\bfseries}l @{\\hspace{6ex}} l }\n" +
                "Git & Advanced \\\\ \n" +
                "\\end{tabular}\n" +
                ending(), accessibleSkills.process().toString());
    }

    @Test
    void allFieldsNumber() {
        ArrayList<AccessibleSkills.Skill> skills = new ArrayList<>();
        AccessibleSkills.Skill skill = new AccessibleSkills.Skill();
        skill.name = "Git";
        skill.level = GradingScale.Level.FIVE;
        skills.add(skill);
        AccessibleSkills accessibleSkills = new AccessibleSkills(new NumberScale(), skills);
        assertEquals(beginning() +
                "\\cvskill{Git}{5}\n" +
                ending(), accessibleSkills.process().toString());
    }

    @Test
    void onlyNameLevel() {
        ArrayList<AccessibleSkills.Skill> skills = new ArrayList<>();
        AccessibleSkills.Skill skill = new AccessibleSkills.Skill();
        skill.name = "Git";
        skills.add(skill);
        AccessibleSkills accessibleSkills = new AccessibleSkills(new LevelScale(), skills);
        assertEquals(beginning() +
                "\\begin{tabular}{ @{} >{\\bfseries}l @{\\hspace{6ex}} l }\n" +
                "Git \\\\ \n" +
                "\\end{tabular}\n" +
                ending(), accessibleSkills.process().toString());
    }

    @Test
    void onlyNameNumber() {
        ArrayList<AccessibleSkills.Skill> skills = new ArrayList<>();
        AccessibleSkills.Skill skill = new AccessibleSkills.Skill();
        skill.name = "Git";
        skills.add(skill);
        AccessibleSkills accessibleSkills = new AccessibleSkills(new NumberScale(), skills);
        assertEquals(beginning() +
                "\\cvskill{Git}{}\n" +
                ending(), accessibleSkills.process().toString());
    }

    @Test
    void onlySkillLevel() {
        ArrayList<AccessibleSkills.Skill> skills = new ArrayList<>();
        AccessibleSkills.Skill skill = new AccessibleSkills.Skill();
        skill.level = GradingScale.Level.FIVE;
        skills.add(skill);
        AccessibleSkills accessibleSkills = new AccessibleSkills(new LevelScale(), skills);
        assertEquals(beginning() +
                "\\begin{tabular}{ @{} >{\\bfseries}l @{\\hspace{6ex}} l }\n" +
                "\\end{tabular}\n" +
                ending(), accessibleSkills.process().toString());
    }


    @Test
    void onlySkillNumber() {
        ArrayList<AccessibleSkills.Skill> skills = new ArrayList<>();
        AccessibleSkills.Skill skill = new AccessibleSkills.Skill();
        skill.level = GradingScale.Level.FIVE;
        skills.add(skill);
        AccessibleSkills accessibleSkills = new AccessibleSkills(new NumberScale(), skills);
        assertEquals(beginning() +
                ending(), accessibleSkills.process().toString());
    }

    private String beginning() {
        return "\\begin{cvsection}{Skills}\n\n";
    }

    private String ending() {
        return "\\end{cvsection}\n\n";
    }

    // TODO split on different scales
    // TODO refactor this
}