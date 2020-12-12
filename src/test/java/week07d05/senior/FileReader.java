package week07d05.senior;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {

    Path file;

    public FileReader(String file) {
        this.file = Path.of(file);
    }

    public List<String> getLinesFromFile() {
        List<String> lines = null;

        try {
            lines = Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
