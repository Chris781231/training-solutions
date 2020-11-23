package recursion.faktorialis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialTest {

    Factorial factorial = new Factorial();

    @Test
    void getFactorialWithLoopTest() {
        assertEquals(120, factorial.getFactorialWithLoop(5));
    }

    @Test
    void getFactorialWithRecursion() {
        assertEquals(120, factorial.getFactorialWithRecursion(5));
    }
}