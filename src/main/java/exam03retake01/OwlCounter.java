package exam03retake01;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {

    private Map<String, Integer> numberOfOwls = new HashMap<>();

    public void readFromFile(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            processLine(line);
        }

    }

    private void processLine(String line) {
        String[] temp = line.split("=");
        numberOfOwls.put(temp[0], Integer.parseInt(temp[1]));
    }

    public int getNumberOfOwls(String county) {
        return numberOfOwls.get(county);
    }
}
