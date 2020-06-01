package com.github.thomoncik.resumebuilder.sections;

import java.util.ArrayList;

public class ExtraCurricularActivities implements Section {

    private final ArrayList<Activity> activities;

    public ExtraCurricularActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    public static class Activity{
        public String title;
        public String employer;
        public String startDate;
        public String endDate;
        public String location;
        public String description;
    }

    @Override
    public StringBuilder process() {
        if (activities == null || activities.isEmpty()) return null;
        StringBuilder result = new StringBuilder();
        result.append("\\begin{cvsection}{Extra Curricular Activities}\n\n");
        for (Activity activity : activities) {
            result.append(processJob(activity));
        }
        result.append("\\end{cvsection}\n\n");
        return result;
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

    private StringBuilder processDescription(Activity activity) {
        StringBuilder result = new StringBuilder();
        if (activity.description == null || activity.description.isBlank()){
            return new StringBuilder();
        }
        String[] lines = activity.description.split("\n");
        for (String line : lines) {
            result.append("\\item ").append(line).append("\n");
        }
        return result;
    }

    private StringBuilder processJob(Activity activity) {
        StringBuilder result = new StringBuilder();
        result.append("\\begin{ACTIVITY}{").append(resolveEmpty(activity.employer)).append("}");
        result.append("{").append(processDate(activity.startDate, activity.endDate)).append("}");
        result.append("{").append(resolveEmpty(activity.title)).append("}");
        result.append("{").append(resolveEmpty(activity.location)).append("}\n");
        result.append(processDescription(activity));
        result.append("\\end{ACTIVITY}\n\n");
        return result;
    }

    // TODO this is the same as work
}
