package controladvanced.cars;

import java.util.ArrayList;
import java.util.List;

public class UsedCars {

    public List<String> filterLines(List<String> lines) {

        List<String> validLines = new ArrayList<>();

        for (String line: lines) {
            String[] parts = line.split(";");

            if(parts.length != 4) {
                continue;
            }

            // License plate number must contain a hyphen
            if (!parts[0].contains("-") || parts[0].length() != 7) {
                continue;
            }

            // The manufacture's year must be between 1970 and 2019
            int year = Integer.parseInt(parts[1]);
            if (year < 1970 || year > 2019) {
                continue;
            }

            validLines.add(line);
        }

        return validLines;
    }
}
