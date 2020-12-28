package ioreadbytes.bytematrix;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MatrixReader {

    private final List<byte[]> myMatrix = new ArrayList<>();

    public static final int BUFFER_SIZE = 1000;

    public void readBytesAndCreateMatrix(String fileName) {
        Path file = Path.of(fileName);

        try (InputStream inputStream = Files.newInputStream(file)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            while (inputStream.read(buffer) > 0) {
                myMatrix.add(buffer);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
    }

    public int numberOfColumnsWhereMoreZeros() {
        int numberOfColumn = 0;

        for (int i = 0; i < BUFFER_SIZE; i++) {
            int zeros = 0;
            int ones = 0;

            for (byte[] matrix : myMatrix) {
                switch (matrix[i]) {
                    case '0' -> zeros++;
                    case '1' -> ones++;
                    default -> throw new IllegalStateException("Invalid content in file");
                }
            }

            if (zeros > ones) {
                numberOfColumn++;
            }
        }
        return numberOfColumn;
    }

    public List<byte[]> getMyMatrix() {
        return new ArrayList<>(myMatrix);
    }
}
