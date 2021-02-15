package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {

    public String createHistogram(BufferedReader reader) throws IOException {
        if (reader == null) {
            throw new IllegalArgumentException("Reader is invalid");
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            try {
                sb.append(processLine(line)).append('\n');
            } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("Invalid file content", nfe);
            }
        }
        return sb.toString();
    }

    private String processLine(String line) {
        int count = Integer.parseInt(line);

        return "*".repeat(Math.max(0, count));
    }
}
