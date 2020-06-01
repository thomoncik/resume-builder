package com.github.thomoncik.resumebuilder.sections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EducationTest {

    @Test
    void canNotProcessNull() {
        Education education = new Education(null);
        assertNull(education.process());
    }

    @Test
    void canNotProcessEmpty() {
        Education education = new Education(new ArrayList<>());
        assertNull(education.process());
    }

    @Test
    void processAllNull() {
        Education.University university = new Education.University();
        ArrayList<Education.University> universities = new ArrayList<>();
        universities.add(university);
        Education education = new Education(universities);
        assertEquals("\\begin{cvsection}{Education}\n\n" +
                "\\begin{EDUCATION}{}{}{}{}\n" +
                "\\end{EDUCATION}\n\n" +
                "\\end{cvsection}", education.process());
    }

}