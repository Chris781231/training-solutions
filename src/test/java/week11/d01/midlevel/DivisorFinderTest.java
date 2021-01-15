package week11.d01.midlevel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisorFinderTest {

    @Test
    void findDivisorsTest() {
        assertEquals(1, new DivisorFinder().findDivisors(425));
        assertEquals(1, new DivisorFinder().findDivisors(4));
    }
}