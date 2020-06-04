package com.github.thomoncik.resumebuilder.model.sections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CoursesTest {

    @Test
    void canNotProcessNull() {
        Courses courses = new Courses(null);
        assertNull(courses.process());
    }

    @Test
    void canNotProcessEmpty() {
        Courses courses = new Courses(new ArrayList<>());
        assertNull(courses.process());
    }

    @Test
    void emptyFields() {
        ArrayList<Courses.Course> list = new ArrayList<>();
        list.add(new Courses.Course());
        Courses courses = new Courses(list);
        assertEquals("\\begin{cvsection}{Courses}\n\n" +
                "\\begin{COURSE}{}{}{}\n" +
                "\\end{COURSE}\n\n" +
                "\\end{cvsection}\n\n", courses.process().toString());
    }

}