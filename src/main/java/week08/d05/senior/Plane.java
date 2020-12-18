package week08.d05.senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Plane {

    public static final String FILENAME = "map.txt";

    private boolean isOceanPrevious;
    private int maxLengthOfOcean = Integer.MIN_VALUE;
    private int lengthOfOcean;

    public int getMaxLengthOfOcean() {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(FILENAME))) {
            int nextChar;
            while ((nextChar = reader.read()) != -1) {
                char terrainType = Character.toString(nextChar).charAt(0);
                checkTerrainType(terrainType);

                if (isOceanActual(terrainType) && !isOceanPrevious) {
                    lengthOfOcean = 0;
                    checkMaxLengthOfOcean();
                    isOceanPrevious = true;
                } else if (isOceanActual(terrainType)) {
                    checkMaxLengthOfOcean();
                } else {
                    isOceanPrevious = false;
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid path or filename");
        }

        return maxLengthOfOcean;
    }

    private void checkTerrainType(char terrainType) {
        if (terrainType < '0' || terrainType > '1') {
            throw new IllegalStateException("Invalid data in " + FILENAME);
        }
    }

    private boolean isOceanActual(char terrainType) {
        return terrainType == '0';
    }

    private void checkMaxLengthOfOcean() {
        if (++lengthOfOcean > maxLengthOfOcean) {
            maxLengthOfOcean = lengthOfOcean;
        }
    }
}
