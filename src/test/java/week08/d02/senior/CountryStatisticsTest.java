package week08.d02.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CountryStatisticsTest {

    CountryStatistics cs = new CountryStatistics();

    @Test
    void createWithFalseDataInCountriesFileTest() {
        InvalidContentFormatException icfe = assertThrows(InvalidContentFormatException.class, () -> new CountryStatistics("countriesWithFalseData.txt"));
        assertEquals("there is wrong data format in country file", icfe.getMessage());
    }

    @Test
    void getCountriesTest() {
        assertEquals("Country{name='Nepal', population=31, numberOfBadgeColors=3, numberOfNeighbours=2}",
                cs.getCountries().get(0).toString());
    }

    @Test
    void maxPopulation() {
        assertEquals("Country{name='Kongoi_Demokratikus_Koztarsasag', population=79, numberOfBadgeColors=3, numberOfNeighbours=9}",
                cs.maxPopulation().toString());
    }
}