package ioreadwritebytes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {

    public Temperatures readTemperatures(String pathString) {
        Path file = Path.of(pathString);
        try {
            byte[] temperatureDatas = Files.readAllBytes(file);
            return new Temperatures(temperatureDatas);
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid path or filename", e);
        }
    }
}
