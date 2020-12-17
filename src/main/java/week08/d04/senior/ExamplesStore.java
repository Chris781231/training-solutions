package week08.d04.senior;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ExamplesStore {

    public List<String> getTitlesOfExamples() {
        List<String> titles = new ArrayList<>();
        Path file = Path.of("examples.md");
        try {
            List<String> lines = Files.readAllLines(file);

            for (String line : lines) {
                if (line.startsWith("#")) {
                    titles.add(line.substring(2));
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Wrong path or filename");
        }

        return titles;
    }
}
