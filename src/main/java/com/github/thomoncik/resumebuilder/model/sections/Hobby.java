package com.github.thomoncik.resumebuilder.model.sections;

public class Hobby implements Section {

    private final String description;

    public Hobby(String description) {
        this.description = description;
    }

    @Override
    public StringBuilder process() {
        if (description == null){
            return null;
        }
        StringBuilder result = new StringBuilder();
        result.append("\\begin{cvsection}{Hobby}\n")
                .append(description).append("\n")
                .append("\\end{cvsection}\n\n");
        return result;
    }
}
