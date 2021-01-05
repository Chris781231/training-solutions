package week09.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibCalculatorTest {

    @Test
    void testSumEvens() {
        FibCalculator fibCalculator = new FibCalculator();
        assertEquals(10, fibCalculator.sumEvens(10));
    }
}