package com.github.thomoncik.resumebuilder.sections;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LanguagesTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void canNotProcessNull() {
        Languages languages = new Languages(null);
        assertNull(languages.process());
    }

    @Test
    void canNotProcessEmpty() {
        Languages languages = new Languages(new ArrayList<>());
        assertNull(languages.process());
    }

    @Test
    void onlyName() {
        Languages.Language language = new Languages.Language();
        language.name = "Polish";
        ArrayList<Languages.Language> list = new ArrayList<>();
        list.add(language);
        Languages languages = new Languages(list);
        assertEquals(beginning() +
                "\\begin{tabular}{ @{} >{\\bfseries}l @{\\hspace{6ex}} l }\n" +
                "Polish \\\\ \n" +
                "\\end{tabular}\n" +
                ending(), languages.process().toString());
    }

    @Test
    void onlyLevel() {
        Languages.Language language = new Languages.Language();
        language.level = Languages.Level.A1;
        ArrayList<Languages.Language> list = new ArrayList<>();
        list.add(language);
        Languages languages = new Languages(list);
        assertEquals(beginning() +
                "\\begin{tabular}{ @{} >{\\bfseries}l @{\\hspace{6ex}} l }\n" +
                "\\end{tabular}\n" +
                ending(), languages.process().toString());
    }

    @Test
    void allFields() {
        Languages.Language language = new Languages.Language();
        language.name = "Polish";
        language.level = Languages.Level.B2PLUS;
        ArrayList<Languages.Language> list = new ArrayList<>();
        list.add(language);
        Languages languages = new Languages(list);
        assertEquals(beginning() +
                "\\begin{tabular}{ @{} >{\\bfseries}l @{\\hspace{6ex}} l }\n" +
                "Polish & B2+ \\\\ \n" +
                "\\end{tabular}\n" +
                ending(), languages.process().toString());
    }

    private String beginning() {
        return "\\begin{cvsection}{Languages}\n\n";
    }

    private String ending() {
        return "\\end{cvsection}\n\n";
    }
}