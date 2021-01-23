package week12.d03.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AgeSorterTest {

    @Test
    void sortAges() {
        int[] ages = new int[]{1, 4, 6, 34, 52, 16, 63, 100, 54, 6, 2};
        int[] sortedAges = new int[]{1, 2, 4, 6, 6, 16, 34, 52, 54, 63, 100};
        assertArrayEquals(sortedAges, new AgeSorter().sortAges(ages));
    }
}