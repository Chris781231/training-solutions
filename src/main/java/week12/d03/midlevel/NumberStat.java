package week12.d03.midlevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberStat {

    public static final String SEPARATOR = ",";
    List<Integer> numbers = new ArrayList<>();

    public void readFromFile(String path) {
        if (isEmpty(path)) {
            throw new IllegalArgumentException("path is empty");
        }
        Path file = Path.of(path);
        int lineCount = 1;
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line, lineCount, path);
                lineCount++;
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("cannot read file");
        }
    }

    public int getOnesOccur() {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }
        List<Integer> onesOccurs = new ArrayList<>();
        List<Integer> multiplyOccurs = new ArrayList<>();
        for (Integer number : numbers) {
            if (!multiplyOccurs.contains(number) && !onesOccurs.contains(number)) {
                onesOccurs.add(number);
            } else if (!multiplyOccurs.contains(number) && onesOccurs.contains(number)) {
                onesOccurs.remove(number);
                multiplyOccurs.add(number);
            }
        }
        return Collections.min(onesOccurs);
    }

    private void processLine(String line, int lineCount, String file) {
        String[] temp = line.split(SEPARATOR);
        for (String s : temp) {
            try {
                numbers.add(Integer.parseInt(s));
            } catch (NumberFormatException nfe) {
                throw new IllegalStateException(String.format("invalid file content in %s line of %s", lineCount, file));
            }
        }

    }

    private boolean isEmpty(String path) {
        return path == null || path.isBlank();
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
