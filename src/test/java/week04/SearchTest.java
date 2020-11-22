package week04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchTest {

    @Test
    void getPositionsOfCharsTest() {
        assertEquals(List.of(0, 3), new Search().getPositionsOfChars("alma", "a"));
        assertEquals(List.of(0, 1, 2), new Search().getPositionsOfChars("aaaa", "aa"));

        assertEquals(List.of(3), new Search().getPositionsOfChars("Alma", "a"));
    }
}