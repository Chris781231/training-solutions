package week07d01.midlevel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathAlgorithmsTest {

    @Test
    void primeFalseTest() {
        assertFalse(MathAlgorithms.isPrime(-1));
        assertFalse(MathAlgorithms.isPrime(0));
        assertFalse(MathAlgorithms.isPrime(1));

        assertFalse(MathAlgorithms.isPrime(-10));
        assertFalse(MathAlgorithms.isPrime(-8));
        assertFalse(MathAlgorithms.isPrime(-6));
        assertFalse(MathAlgorithms.isPrime(-4));
        assertFalse(MathAlgorithms.isPrime(4));
        assertFalse(MathAlgorithms.isPrime(6));
        assertFalse(MathAlgorithms.isPrime(8));
        assertFalse(MathAlgorithms.isPrime(10));

        assertFalse(MathAlgorithms.isPrime(-2361));
        assertFalse(MathAlgorithms.isPrime(975421368));
    }

    @Test
    void primeTrueTest() {
        assertTrue(MathAlgorithms.isPrime(-7));
        assertTrue(MathAlgorithms.isPrime(-5));
        assertTrue(MathAlgorithms.isPrime(-3));
        assertTrue(MathAlgorithms.isPrime(-2));
        assertTrue(MathAlgorithms.isPrime(2));
        assertTrue(MathAlgorithms.isPrime(3));
        assertTrue(MathAlgorithms.isPrime(5));
        assertTrue(MathAlgorithms.isPrime(7));

        assertTrue(MathAlgorithms.isPrime(-17));
        assertTrue(MathAlgorithms.isPrime(137));
    }
}