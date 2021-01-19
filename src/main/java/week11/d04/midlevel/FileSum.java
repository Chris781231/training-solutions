package week11.d04.midlevel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSum {

    public static void main(String[] args) {
        System.out.println(new FileSum().sumNumbers());
    }

    public int sumNumbers() {
        int sum = 0;

        for (int i = 0; i < 100; i++) {
            String fileName = getFileName(i);

            if (Files.isRegularFile(Path.of(fileName))) {
                int content = readFromFile(fileName);
                sum += content;
            }
        }

        return sum;
    }

    private String getFileName(int i) {
        return String.format("number%02d.txt", i);
    }

    private int readFromFile(String fileName) {
        int content;
        try {
            content = Integer.parseInt(Files.readString(Path.of(fileName)));
        } catch (IOException ioe) {
            throw new IllegalStateException("cannot read file", ioe);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("not a number", nfe);
        }
        return content;
    }
}
