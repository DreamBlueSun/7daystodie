package ume.marisa.iridescent.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    public static void output(String content) {
        String filePath = "D:\\idea-workspace-ume\\7daystodie\\iridescent\\src\\output\\output.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}