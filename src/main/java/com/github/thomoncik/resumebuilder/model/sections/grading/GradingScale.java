package com.github.thomoncik.resumebuilder.model.sections.grading;

import com.github.thomoncik.resumebuilder.model.sections.AccessibleSkills;

public interface GradingScale {

    public enum Level {ONE, TWO, THREE, FOUR, FIVE}

    public String process(AccessibleSkills.Skill skill);

    public String beginning();

    public String ending();
}
