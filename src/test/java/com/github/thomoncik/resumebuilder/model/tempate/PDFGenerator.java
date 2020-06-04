package com.github.thomoncik.resumebuilder.model.tempate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PDFGenerator {


    void writeFile(String result, String where) {
        File file = new File(where);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        try (PrintWriter out = new PrintWriter(file)) {
            out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void generate(String result, File template) {
        File dir = new File("./out/");
        dir.mkdir();
        writeFile(result, "./out/resume.tex");
        try {
            writeFile(Files.readString(template.toPath()), "./out/resume.cls");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}