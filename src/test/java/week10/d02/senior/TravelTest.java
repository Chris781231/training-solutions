package week10.d02.senior;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class TravelTest {

    @Test
    void getStopWithMaxTest() {
        InputStream in = Travel.class.getResourceAsStream("utasadat.txt");
        assertEquals(3, new Travel().getStopWithMax(in));
    }
}