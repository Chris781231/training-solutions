package week07d02.midlevel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DigitSumTest {

    @Test
    void sumOfDigitsTest() {
        assertEquals(15, new DigitSum().sumOfDigits(12345));
        assertEquals(0, new DigitSum().sumOfDigits(0));
    }

    @Test
    void sumOfDigitsRecursionTest() {
        assertEquals(15, new DigitSum().sumOfDigitsRecursion(12345));
        assertEquals(1, new DigitSum().sumOfDigitsRecursion(1));
        assertEquals(45, new DigitSum().sumOfDigitsRecursion(1875604239));
    }
}