package week13.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityFinderTest {

    @Test
    void getMaxLengthCity() {
        CityFinder cityFinder = new CityFinder();
        int maxLengthCity = cityFinder.getMaxLengthCity(CityFinder.class.getResourceAsStream("/iranyiroszamok-varosok-2021.csv"));
        assertEquals(23, maxLengthCity);
    }
}