package week13.d01.midlevel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CityFinderTest {

    @Test
    void getMaxLengthCity() {
        CityFinder cityFinder = new CityFinder();
        String maxLengthCity = cityFinder.readCitiesFromFile(CityFinder.class.getResourceAsStream("/iranyitoszamok-varosok-2021.csv"));
        System.out.println(maxLengthCity);
        assertEquals("Jászfelsőszentgyörgy", maxLengthCity);
    }
}