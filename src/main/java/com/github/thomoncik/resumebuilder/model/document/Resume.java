package com.github.thomoncik.resumebuilder.model.document;

import com.github.thomoncik.resumebuilder.model.sections.Section;

import java.util.ArrayList;

public class Resume extends Document {

    public Resume(ArrayList<Section> sections) {
        Document.sections = sections;
    }

    @Override
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
