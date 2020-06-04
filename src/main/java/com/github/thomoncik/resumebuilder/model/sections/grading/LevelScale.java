package com.github.thomoncik.resumebuilder.model.sections.grading;

import com.github.thomoncik.resumebuilder.model.sections.AccessibleSkills;

public class LevelScale implements GradingScale {
    @Override
    public String process(AccessibleSkills.Skill skill) {
        if (skill == null || skill.name == null || skill.name.isBlank()){
            return "";
        }
        if (skill.level == null){
            return skill.name + " \\\\ \n";
        }
        switch (skill.level){
            case ONE: return skill.name + " & Novice \\\\ \n";
            case TWO: return skill.name + " & Beginner \\\\ \n";
            case THREE: return skill.name + " & Skillful \\\\ \n";
            case FOUR: return skill.name + " & Experienced \\\\ \n";
            case FIVE: return skill.name + " & Advanced \\\\ \n";
        }
        return null;
    }


    @Override
    public String beginning() {
        return "\\begin{tabular}{ @{} >{\\bfseries}l @{\\hspace{6ex}} l }\n";
    }

    @Override
    public String ending() {
        return "\\end{tabular}\n";
    }
}
