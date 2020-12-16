package iowritestring.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Register {

    public void newMark(Path path, int mark) {
        try {
            if (Files.exists(path)) {
                Files.writeString(path, mark + "\n", StandardOpenOption.APPEND);
            } else {
                Files.writeString(path, Integer.toString(mark));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Invalid path or filename", e);
        }
    }

    public void average(Path file) {
        try {
            int sum = 0;
            int count = 0;
            double average = 0;
            List<String> marks = Files.readAllLines(file);

            for (String mark : marks) {
                sum += Integer.parseInt(mark.strip());
                count++;
            }

            if (count != 0) {
                average = (double) sum / count;
            }

            Files.writeString(file, "average: " + average, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IllegalStateException("Invalid path or filename", e);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Invalid mark in file", e);
        }
    }
}
