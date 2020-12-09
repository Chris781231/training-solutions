package week07d03.midlevel;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberListTest {

    List<Integer> isCreasingNumbers = List.of(1, 2, 3, 3, 4, 4, 4, 6, 10);
    List<Integer> isNotCreasingNumbers = List.of(1, 2, 3, 4, 3, 4, 4, 6, 10);

    @Test
    void isIncreasingTest() {
        assertTrue(new NumberList().isIncreasing(isCreasingNumbers));
        assertFalse(new NumberList().isIncreasing(isNotCreasingNumbers));
    }
}