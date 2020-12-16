package ioreadstring.names;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private final Path myFile;
    private final List<Human> humans = new ArrayList<>();

    public FileManager(String path) {
        this.myFile = Path.of(path);
    }

    public void readFromFile() {
        try {
            List<String> names = Files.readAllLines(myFile);
            for (String name : names) {
                String[] nameItems = name.split(" ");
                humans.add(new Human(nameItems[0], nameItems[1]));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Invalid path or filename", e);
        }
    }

    public Path getMyFile() {
        return myFile;
    }

    public List<Human> getHumans() {
        return new ArrayList<>(humans);
    }
}
