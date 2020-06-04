package com.github.thomoncik.resumebuilder.model.sections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ExtraCurricularActivitiesTest {

    @Test
    void canNotProcessNull() {
        ExtraCurricularActivities activities = new ExtraCurricularActivities(null);
        assertNull(activities.process());
    }

    @Test
    void canNotProcessEmpty() {
        ExtraCurricularActivities activities = new ExtraCurricularActivities(new ArrayList<>());
        assertNull(activities.process());
    }
}