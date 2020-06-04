package com.github.thomoncik.resumebuilder.sections;

import java.util.ArrayList;

public class Courses implements Section {

    private final ArrayList<Course> courses;

    public Courses(ArrayList<Course> courses) {
        this.courses = courses;
    }


    public static class Course {
        public String name;
        public String startDate;
        public String endDate;
        public String institution;
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
        if (courses == null || courses.isEmpty()) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        result.append("\\begin{cvsection}{Courses}\n\n");
        for (Course course : courses) {
            result.append(processCourse(course));
        }
        result.append("\\end{cvsection}\n\n");
        return result;
    }

    private StringBuilder processCourse(Course course) {
        StringBuilder result = new StringBuilder();
        result.append("\\begin{COURSE}{").append(resolveEmpty(course.name)).append("}");
        result.append("{").append(processDate(course.startDate, course.endDate)).append("}");
        result.append("{").append(resolveEmpty(course.institution)).append("}\n");
        result.append("\\end{COURSE}\n\n");
        return result;
    }
}
