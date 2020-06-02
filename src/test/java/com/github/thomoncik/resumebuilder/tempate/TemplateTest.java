package com.github.thomoncik.resumebuilder.tempate;

import com.github.thomoncik.resumebuilder.sections.Hobby;
import com.github.thomoncik.resumebuilder.sections.PersonalInformation;
import com.github.thomoncik.resumebuilder.sections.Section;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TemplateTest {

    @Test
    void process() {
        ArrayList<Section> sections = new ArrayList<>();
        sections.add(new Hobby("this is hobby"));
        Template template = new Template(sections);
//        assertEquals("", template.process());
    }
}