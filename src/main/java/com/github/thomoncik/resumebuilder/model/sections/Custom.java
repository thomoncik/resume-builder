package com.github.thomoncik.resumebuilder.model.sections;

import java.util.ArrayList;

public class Custom implements Section {


    private final ArrayList<Item> items;

    public Custom(ArrayList<Item> items) {
        this.items = items;
    }

    public static class Item {
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
        if (items == null || items.isEmpty()) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        result.append("\\begin{cvsection}{Projects}\n\n");
        for (Item iItem : items) {
            result.append(processProject(iItem));
        }
        result.append("\\end{cvsection}\n\n");
        return result;
    }

    private StringBuilder processDescription(Item iItem) {
        StringBuilder result = new StringBuilder();
        if (iItem.description == null || iItem.description.isBlank()){
            return new StringBuilder();
        }
        String[] lines = iItem.description.split("\n");
        for (String line : lines) {
            result.append("\\item ").append(line).append("\n");
        }
        return result;
    }

    private StringBuilder processProject(Item iItem) {
        StringBuilder result = new StringBuilder();
        result.append("\\begin{CUSTOM}{").append(resolveEmpty(iItem.title)).append("}");
        result.append("{").append(processDate(iItem.startDate, iItem.endDate)).append("}");
        result.append("{").append(resolveEmpty(iItem.location)).append("}");
        result.append(processDescription(iItem));
        result.append("\\end{CUSTOM}\n\n");
        return result;
    }

    // TODO this is copy of project
}
