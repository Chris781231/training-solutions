package week08.d02.senior;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountryStatistics {

    private final List<Country> countries = new ArrayList<>();

    public CountryStatistics() {
        this("countries.txt");
    }

    public CountryStatistics(String file) {
        if (file == null || file.isBlank()) {
            throw new IllegalArgumentException("file is empty or null");
        }
        loadUpCountriesList(file);
    }

    private void loadUpCountriesList(String file) {
        try (Scanner scanner = new Scanner(Path.of(file))) {
            while (scanner.hasNextLine()) {
                loadUpLine(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // TODO: 2020. 12. 15. make exception handling
    private void loadUpLine(String line) {
        String[] lineItems = line.split(" ");
        if (lineItems.length != 4) {
            throw new InvalidContentFormatException("there is wrong data format in country file");
        }

        String name = lineItems[0];
        try {
            int population = Integer.parseInt(lineItems[1]);
            int numberOfBadgeColors = Integer.parseInt(lineItems[2]);
            int numberOfNeighbours = Integer.parseInt(lineItems[3]);

            countries.add(new Country(name, population, numberOfBadgeColors, numberOfNeighbours));
        } catch (NumberFormatException e) {
            throw new InvalidContentFormatException("there is wrong data format in country file");
        }
    }

    public Country maxPopulation() {
        int max = Integer.MIN_VALUE;
        Country country = null;

        for (Country c : countries) {
            if (c.getPopulation() > max) {
                max = c.getPopulation();
                country = c;
            }
        }

        return country;
    }

    public List<Country> getCountries() {
        return new ArrayList<>(countries);
    }
}
