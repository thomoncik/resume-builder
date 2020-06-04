package com.github.thomoncik.resumebuilder.model.sections;

import java.util.ArrayList;

public class Languages implements Section {

    private final ArrayList<Language> languages;

    public Languages(ArrayList<Language> languages) {
        this.languages = languages;
    }

    public enum Level {A1, A2, B1, B2, B2PLUS, C1, C2}

    public static class Language{
        public String name;
        public Level level;
    }

    private String processLanguage(Language language){
        if (language == null || language.name == null){
            return "";
        }
        if (language.level == null){
            return language.name + " \\\\ \n";
        }
        switch (language.level){
            case A1: return language.name + " & A1 \\\\ \n";
            case A2: return language.name + " & A2 \\\\ \n";
            case B1: return language.name + " & B1 \\\\ \n";
            case B2: return language.name + " & B2 \\\\ \n";
            case B2PLUS: return language.name + " & B2+ \\\\ \n";
            case C1: return language.name + " & C1 \\\\ \n";
            case C2: return language.name + " & C2 \\\\ \n";
        }
        return null;
    }

    @Override
    public StringBuilder process() {
        if (languages == null || languages.isEmpty()) return null;
        StringBuilder result = new StringBuilder();
        result.append("\\begin{cvsection}{Languages}\n\n");
        result.append(beginning());
        for (Language language : languages) {
            result.append(processLanguage(language));
        }
        result.append(ending());
        result.append("\\end{cvsection}\n\n");
        return result;
    }


    public String beginning() {
        return "\\begin{tabular}{ @{} >{\\bfseries}l @{\\hspace{6ex}} l }\n";
    }

    public String ending() {
        return "\\end{tabular}\n";
    }
}
