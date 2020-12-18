package week08.d05.senior;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlaneTest {

    private Plane plane;

    @BeforeEach
    void setUp() {
        plane = new Plane();
    }

    @Test
    void getMaxLengthOfOceanTest() {
        assertEquals(16, plane.getMaxLengthOfOcean());
    }
}