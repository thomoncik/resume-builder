package com.github.thomoncik.resumebuilder.sections;

import java.util.ArrayList;

public class WorkExperience implements Section {

    private final ArrayList<WorkExperience.Job> jobs;

    public WorkExperience(ArrayList<WorkExperience.Job> jobs){
        this.jobs = jobs;
    }

    public static class Job {
        public String title;
        public String employer;
        public String startDate;
        public String endDate;
        public String location;
        public String description;
    }

    @Override
    public StringBuilder process() {
        if (jobs == null || jobs.isEmpty()) return null;
        StringBuilder result = new StringBuilder();
        result.append("\\begin{cvsection}{Employment history}\n\n");
        for (WorkExperience.Job job : jobs) {
            result.append(processJob(job));
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

    private StringBuilder processDescription(WorkExperience.Job job) {
        StringBuilder result = new StringBuilder();
        if (job.description == null || job.description.isBlank()){
            return new StringBuilder();
        }
        String[] lines = job.description.split("\n");
        for (String line : lines) {
            result.append("\\item ").append(line).append("\n");
        }
        return result;
    }

    private StringBuilder processJob(Job job) {
        StringBuilder result = new StringBuilder();
        result.append("\\begin{WORK}{").append(resolveEmpty(job.title)).append("}");
        result.append("{").append(processDate(job.startDate, job.endDate)).append("}");
        result.append("{").append(resolveEmpty(job.employer)).append("}");
        result.append("{").append(resolveEmpty(job.location)).append("}\n");
        result.append(processDescription(job));
        result.append("\\end{WORK}\n\n");
        return result;
    }
}
