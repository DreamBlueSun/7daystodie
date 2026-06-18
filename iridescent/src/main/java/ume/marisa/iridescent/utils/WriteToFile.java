package ume.marisa.iridescent.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    private static final String OUTPUT_DIR = "iridescent/src/output";

    public static void output(String content) {
        File dir = new File(OUTPUT_DIR);
        if (!dir.exists()) dir.mkdirs();
        String filePath = OUTPUT_DIR + "/output.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}