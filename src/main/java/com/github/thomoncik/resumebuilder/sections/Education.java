package com.github.thomoncik.resumebuilder.sections;

import java.util.ArrayList;

public class Education implements Section {

    private final ArrayList<University> universities;

    public static class University {
        public String name;
        public String degree;
        public String startDate;
        public String endDate;
        public String location;
        public String description;
    }

    public Education(ArrayList<University> universities) {
        this.universities = universities;
    }


    private String processDate(String start, String end) {
        if (start == null || start.isBlank()) return "";
        if (end == null || end.isBlank()) return start;
        if (start.equals(end)) return start;
        return start + " - " + end;
    }

    private String resolveEmpty(String string) {
        return string == null || string.isEmpty() || string.isBlank() ? "" : string;
    }


    private StringBuilder processUniversity(University university) {
        StringBuilder result = new StringBuilder();
        result.append("\\begin{EDUCATION}{").append(resolveEmpty(university.name)).append("}");
        result.append("{").append(processDate(university.startDate, university.endDate)).append("}");
        result.append("{").append(resolveEmpty(university.degree)).append("}");
        result.append("{").append(resolveEmpty(university.location)).append("}\n");
        result.append(processDescription(university));
        result.append("\\end{EDUCATION}\n\n");
        return result;
    }

    private StringBuilder processDescription(University university) {
        StringBuilder result = new StringBuilder();
        if (university.description == null || university.description.isBlank()){
            return new StringBuilder();
        }
        String[] lines = university.description.split("\n");
        for (String line : lines) {
            result.append("\\item ").append(line).append("\n");
        }
        return result;
    }

    @Override
    public StringBuilder process() {
        if (universities == null || universities.isEmpty()) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        result.append("\\begin{cvsection}{Education}\n\n");
        for (University university : universities) {
            result.append(processUniversity(university));
        }
        result.append("\\end{cvsection}\n\n");
        return result;
    }
}
