package iowriter.music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BandManager {

    private final List<Band> bands = new ArrayList<>();

    public void readBandsFromFile(Path inputFile) {
        try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(";");
                bands.add(new Band(temp[0], Integer.parseInt(temp[1])));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Invalid path or filename");
        } catch (NumberFormatException nfe) {
            throw new IllegalStateException("Invalid year format in file");
        }
    }

    public void writeBandsBefore(Path outputFile, int year) {
        try (BufferedWriter writer = Files.newBufferedWriter(outputFile)) {
            for (Band band : bands) {
                if (band.getYear() < year) {
                    writer.write(band.getName() + " " + band.getYear() + "\n");
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Invalid path or filename");
        }
    }
}
