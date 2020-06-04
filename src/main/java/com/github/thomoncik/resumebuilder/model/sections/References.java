package com.github.thomoncik.resumebuilder.model.sections;

import java.util.ArrayList;

public class References implements Section {


    private final ArrayList<Reference> references;

    public References(ArrayList<Reference> references){
        this.references = references;
    }

    public static class Reference {
        public String name;
        public String company;
        public String phone;
        public String email; // TODO add mailto
    }
    @Override
    public StringBuilder process() {
        if (references == null || references.isEmpty()) return null;
        StringBuilder result = new StringBuilder();
        result.append("\\begin{cvsection}{References}\n\n");
        for (Reference reference : references) {
            result.append(processReference(reference));
        }
        result.append("\\end{cvsection}\n\n");
        return result;    }

    private String resolveEmpty(String string) {
        return string == null || string.isEmpty() || string.isBlank() ? "" : string;
    }

    private StringBuilder processReference(Reference reference) {
        StringBuilder result = new StringBuilder();
        result.append("\\begin{REFERENCE}{").append(resolveEmpty(reference.name)).append("}");
        result.append("{").append(resolveEmpty(reference.company)).append("}");
        result.append("{").append(resolveEmpty(reference.phone)).append("}");
        result.append("{").append(resolveEmpty(reference.email)).append("}\n");
        result.append("\\end{REFERENCE}\n\n");
        return result;
    }
}
