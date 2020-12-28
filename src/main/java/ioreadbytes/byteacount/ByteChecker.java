package ioreadbytes.byteacount;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {

    public int readBytesAndFindAs(String fileName) {
        int sumOfA = 0;
        Path file = Path.of(fileName);

        try (InputStream inputStream = Files.newInputStream(file)) {
            byte[] buffer = new byte[1000];

            while (inputStream.read(buffer) > 0) {
                for (byte b : buffer) {
                    if (b == 'a') {
                        sumOfA++;
                    }
                }
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }

        return sumOfA;
    }
}
