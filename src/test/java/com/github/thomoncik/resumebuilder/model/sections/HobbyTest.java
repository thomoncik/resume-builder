package com.github.thomoncik.resumebuilder.model.sections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HobbyTest {

    @Test
    void processNull() {
        Hobby hobby = new Hobby(null);
        assertNull(hobby.process());
    }

    @Test
    void processEmpty() {
        Hobby hobby = new Hobby("");
        assertEquals("\\begin{cvsection}{Hobby}\n"
                + "\n"
                + "\\end{cvsection}\n\n", hobby.process().toString());
    }

    @Test
    void process() {
        Hobby hobby = new Hobby("description");
        assertEquals("\\begin{cvsection}{Hobby}\n"
                + "description\n"
                + "\\end{cvsection}\n\n", hobby.process().toString());
    }
}