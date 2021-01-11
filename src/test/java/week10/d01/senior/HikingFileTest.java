package week10.d01.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HikingFileTest {

    @Test
    void getPlusElevation() {
        Elevations elevations = new HikingFile().getPlusElevation(HikingFile.class.getResourceAsStream("trackpoints.gpx"));
        assertEquals(20, elevations.getPlusElevation());
        assertEquals(10, elevations.getMinusElevation());
    }
}