package week13.d01.midlevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CityFinder {

    public int getMaxLengthCity(InputStream in) {
        if (in == null) {
            throw new IllegalArgumentException("file is null");
        }
        int maxLength = Integer.MIN_VALUE;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int length = processLine(line);
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("cannot read file", ioe);
        }

        return maxLength;
    }

    private int processLine(String line) {
        String[] temp = line.split(";");
        return temp[temp.length - 1].length();
    }
}
