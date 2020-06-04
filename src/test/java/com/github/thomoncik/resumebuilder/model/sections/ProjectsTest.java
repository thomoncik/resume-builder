package com.github.thomoncik.resumebuilder.model.sections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProjectsTest {

    @Test
    void canNotProcessNull() {
        Projects projects = new Projects(null);
        assertNull(projects.process());
    }

    @Test
    void canNotProcessEmpty() {
        Projects projects = new Projects(new ArrayList<>());
        assertNull(projects.process());
    }

    //TODO more tests
}