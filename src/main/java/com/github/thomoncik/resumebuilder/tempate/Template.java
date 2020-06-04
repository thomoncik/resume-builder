package com.github.thomoncik.resumebuilder.tempate;

import com.github.thomoncik.resumebuilder.sections.Section;

import java.util.ArrayList;

public class Template {

    private final ArrayList<Section> sections;

    public Template(ArrayList<Section> sections) {
        this.sections = sections;
    }

    public String process() {
        StringBuilder result = new StringBuilder();
        result.append("\\documentclass{resume}\n\n\\begin{document}\n\n");
        if (sections != null) {
            for (Section section : sections) {
                result.append(section.process());
            }
        }
        result.append("\\end{document}\n");
        return result.toString();
    }
}
