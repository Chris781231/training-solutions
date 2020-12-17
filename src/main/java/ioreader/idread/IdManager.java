package ioreader.idread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IdManager {

    private final List<String> ids = new ArrayList<>();

    public void readIdsFromFile(String path) {
        Path file = Path.of(path);
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String row;
            while((row = reader.readLine()) != null) {
                ids.add(row);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid path or filename", e);
        }
    }

    public List<String> getIds() {
        return new ArrayList<>(ids);
    }
}
