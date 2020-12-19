package iowriter.names;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NameWriter {

    private final Path file;

    public NameWriter(Path file) {
        this.file = file;
    }

    public void addAndWrite(String name) {
        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardOpenOption.APPEND)) {
            writer.write(name + "\n");
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file");
        }
    }
}
