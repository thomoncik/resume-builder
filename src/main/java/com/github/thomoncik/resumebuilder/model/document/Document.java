package com.github.thomoncik.resumebuilder.model.document;

import com.github.thomoncik.resumebuilder.model.sections.Section;

import java.util.ArrayList;

public abstract class Document {
    public static ArrayList<Section> sections = null;

    public abstract String process();
}
