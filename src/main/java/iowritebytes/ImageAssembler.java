package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssembler {


    public void makeImageFile(byte[][] source, Path folder) {
        Path file = folder.resolve("image.png");
        try (OutputStream stream = new BufferedOutputStream(Files.newOutputStream(file))) {
            for (byte[] temp : source) {
                stream.write(temp);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
    }
}
