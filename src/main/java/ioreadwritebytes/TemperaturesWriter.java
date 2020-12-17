package ioreadwritebytes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesWriter {

    public void writeTemperatures(Temperatures temperatures, String pathString) {
        Path file = Path.of(pathString);
        try {
            Files.write(file, temperatures.getData());
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid path or filename", e);
        }
    }
}
