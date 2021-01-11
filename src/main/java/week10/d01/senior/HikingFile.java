package week10.d01.senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HikingFile {

    public Elevations getPlusElevation(InputStream in) {
        List<Double> elevationsFromFile = readFromFile(in);
        Elevations elevations = new Elevations();
        double prevElevation = 0;

        for (double elevation : elevationsFromFile) {
            if (prevElevation != 0 && prevElevation < elevation) {
                elevations.addPlusElevation(elevation - prevElevation);
            }
            if (prevElevation != 0 && prevElevation > elevation) {
                elevations.addMinusElevation(prevElevation - elevation);
            }
            prevElevation = elevation;
        }

        return elevations;
    }

    private List<Double> readFromFile(InputStream in) {
        List<Double> elevations = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                elevations.add(Double.parseDouble(parts[2]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

        return elevations;
    }
}
