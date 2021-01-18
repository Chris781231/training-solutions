package week11.d03.midlevel;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordFilterTest {

    @Test
    void wordWithChar() {
        WordFilter wordFilter = new WordFilter();
        assertEquals(List.of("alma", "szilva", "banán", "barack"),
                wordFilter.wordWithChar(List.of("alma", "körte", "szilva", "banán", "barack", "szõlõ"), 'a'));
    }
}