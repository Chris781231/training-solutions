package week11.d01.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    @Test
    void findPairsTest() {
        int[] numbers = new int[]{7, 1, 5, 7, 3, 3, 5, 7, 6, 7};
        assertEquals(4, new PairFinder().findPairs(numbers));
    }
}