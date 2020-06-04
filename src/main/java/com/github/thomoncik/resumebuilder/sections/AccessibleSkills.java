package com.github.thomoncik.resumebuilder.sections;

import com.github.thomoncik.resumebuilder.sections.grading.GradingScale;

import java.util.ArrayList;

public class AccessibleSkills implements Section {
    private final GradingScale gradingScale;
    private final ArrayList<Skill> skills;

    public AccessibleSkills(GradingScale gradingScale, ArrayList<Skill> skills){
        this.gradingScale = gradingScale;
        this.skills = skills;
    }

    public static class Skill {
        public String name;
        public GradingScale.Level level;
    }

    @Override
    public StringBuilder process() {
        if (skills == null || skills.isEmpty() || gradingScale == null) return null;
        StringBuilder result = new StringBuilder();
        result.append("\\begin{cvsection}{Skills}\n\n");
        result.append(gradingScale.beginning());
        for (AccessibleSkills.Skill skill : skills) {
            result.append(gradingScale.process(skill));
        }
        result.append(gradingScale.ending());
        result.append("\\end{cvsection}\n\n");
        return result;
    }

}
