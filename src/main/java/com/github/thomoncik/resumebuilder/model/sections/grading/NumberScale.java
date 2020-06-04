package com.github.thomoncik.resumebuilder.model.sections.grading;

import com.github.thomoncik.resumebuilder.model.sections.AccessibleSkills;

public class NumberScale implements GradingScale {
    @Override
    public String process(AccessibleSkills.Skill skill) {
        if (skill == null || skill.name == null || skill.name.isBlank()){
            return "";
        }
        if (skill.level == null){
            return "\\cvskill{" + skill.name + "}{}\n";
        }
        switch (skill.level){
            case ONE: return "\\cvskill{" + skill.name + "}{1}\n";
            case TWO: return "\\cvskill{" + skill.name + "}{2}\n";
            case THREE: return "\\cvskill{" + skill.name + "}{3}\n";
            case FOUR: return "\\cvskill{" + skill.name + "}{4}\n";
            case FIVE: return "\\cvskill{" + skill.name + "}{5}\n";
        }
        return null;
    }

    @Override
    public String beginning() {
        return "";
    }

    @Override
    public String ending() {
        return "";
    }
}
