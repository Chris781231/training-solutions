package week07d01.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    @Test
    void fibonacciLoopTest() {
        assertEquals(0, Fibonacci.fibLoop(0));
        assertEquals(1, Fibonacci.fibLoop(1));
        assertEquals(1, Fibonacci.fibLoop(2));
        assertEquals(2, Fibonacci.fibLoop(3));
        assertEquals(3, Fibonacci.fibLoop(4));
        assertEquals(5, Fibonacci.fibLoop(5));
        assertEquals(8, Fibonacci.fibLoop(6));
    }

    @Test
    void fibonacciRecursionTest() {
        assertEquals(0, Fibonacci.fibRecursion(0));
        assertEquals(1, Fibonacci.fibRecursion(1));
        assertEquals(1, Fibonacci.fibRecursion(2));
        assertEquals(2, Fibonacci.fibRecursion(3));
        assertEquals(3, Fibonacci.fibRecursion(4));
        assertEquals(5, Fibonacci.fibRecursion(5));
        assertEquals(8, Fibonacci.fibRecursion(6));
    }
}