package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StringToBytes {


    public void writeAsBytes(List<String> words, Path file) {
        try (OutputStream stream = new BufferedOutputStream(Files.newOutputStream(file))) {
            for (String s : words) {
                if (!s.startsWith("_")) {
                    stream.write(s.getBytes());
                }
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
    }
}
