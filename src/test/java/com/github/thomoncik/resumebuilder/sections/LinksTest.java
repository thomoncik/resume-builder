package com.github.thomoncik.resumebuilder.sections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LinksTest {
    @Test
    void canNotProcessBothNull() {
        Links links = new Links(null);
        assertNull(links.process());
    }

    @Test
    void canNotProcessNullSkills() {
        Links links = new Links(new ArrayList<>());
        assertNull(links.process());
    }
}