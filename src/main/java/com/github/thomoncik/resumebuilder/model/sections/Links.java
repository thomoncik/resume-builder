package com.github.thomoncik.resumebuilder.model.sections;

import java.util.ArrayList;

public class Links implements Section {

    final private ArrayList<Website> websites;

    public Links(ArrayList<Website> websites) {
        this.websites = websites;
    }

    public static class Website {
        public String label;
        public String link;
    }

    private String resolveEmpty(String string) {
        return string == null || string.isEmpty() || string.isBlank() ? "" : string;
    }

    @Override
    public StringBuilder process() {
        if (websites == null || websites.isEmpty()) return null;
        StringBuilder result = new StringBuilder();
        result.append("\\begin{cvsection}{Links}\n\n");
        for (Website website: websites) {
            result.append("\\cvlink{").append(resolveEmpty(website.label)).append("}{").append(resolveEmpty(website.link)).append("}\n");
        }
        result.append("\\end{cvsection}\n\n");
        return result;
    }
}
