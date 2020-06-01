package com.github.thomoncik.resumebuilder.sections;

import java.util.ArrayList;

public class Projects implements Section {


    private final ArrayList<Project> projects;

    public Projects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public static class Project {
        public String title;
        public String startDate;
        public String endDate;
        public String location;
        public String description;
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

    @Override
    public StringBuilder process() {
        if (projects == null || projects.isEmpty()) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        result.append("\\begin{cvsection}{Projects}\n\n");
        for (Project project : projects) {
            result.append(processProject(project));
        }
        result.append("\\end{cvsection}\n\n");
        return result;
    }

    private StringBuilder processDescription(Project project) {
        StringBuilder result = new StringBuilder();
        if (project.description == null || project.description.isBlank()){
            return new StringBuilder();
        }
        String[] lines = project.description.split("\n");
        for (String line : lines) {
            result.append("\\item ").append(line).append("\n");
        }
        return result;
    }

    private StringBuilder processProject(Project project) {
        StringBuilder result = new StringBuilder();
        result.append("\\begin{PROJECT}{").append(resolveEmpty(project.title)).append("}");
        result.append("{").append(processDate(project.startDate, project.endDate)).append("}");
        result.append("{").append(resolveEmpty(project.location)).append("}");
        result.append(processDescription(project));
        result.append("\\end{PROJECT}\n\n");
        return result;
    }
}
