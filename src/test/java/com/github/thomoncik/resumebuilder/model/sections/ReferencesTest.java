package com.github.thomoncik.resumebuilder.model.sections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReferencesTest {

    @Test
    void canNotProcessNull() {
        References references = new References(null);
        assertNull(references.process());
    }

    @Test
    void canNotProcessEmpty() {
        References references = new References(new ArrayList<>());
        assertNull(references.process());
    }
}