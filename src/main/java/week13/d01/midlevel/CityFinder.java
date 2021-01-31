package week13.d01.midlevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CityFinder {

    public String readCitiesFromFile(InputStream in) {
        if (in == null) {
            throw new IllegalArgumentException("file is null");
        }
        String maxLength = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

            skipHeader(reader);

            return getMaxLength(maxLength, reader);

        } catch (IOException ioe) {
            throw new IllegalStateException("cannot read file", ioe);
        }
    }

    private void skipHeader(BufferedReader reader) throws IOException {
        reader.readLine();
    }

    private String getMaxLength(String maxLength, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts[1].length() > maxLength.length()) {
                maxLength = parts[1];
            }
        }
        return maxLength;
    }
}
