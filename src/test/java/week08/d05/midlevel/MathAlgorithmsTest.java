package week08.d05.midlevel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathAlgorithmsTest {

    MathAlgorithms mathAlgorithms;

    @BeforeEach
    void setUp() {
        mathAlgorithms = new MathAlgorithms();
    }

    @Test
    void getGreatestCommonDivisionShouldExceptionIfOneOfParametersIsZeroTest() {
        assertThrows(IllegalArgumentException.class, () -> mathAlgorithms.getGreatestCommonDivisor(0, 0));
        assertThrows(IllegalArgumentException.class, () -> mathAlgorithms.getGreatestCommonDivisor(5, 0));
        assertThrows(IllegalArgumentException.class, () -> mathAlgorithms.getGreatestCommonDivisor(0, 8));
    }

    @Test
    void getGreatestCommonDivisionTest() {
        assertEquals(6, mathAlgorithms.getGreatestCommonDivisor(18, 24));
        assertEquals(6, mathAlgorithms.getGreatestCommonDivisor(24, 18));
        assertEquals(3, mathAlgorithms.getGreatestCommonDivisor(15, 24));
    }
}