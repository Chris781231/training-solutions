package week11.d03.midlevel;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordFilterTest {

    @Test
    void wordWithChar() {
        WordFilter wordFilter = new WordFilter();
        assertEquals(List.of("alma", "szilva", "ban�n", "barack"),
                wordFilter.wordWithChar(List.of("alma", "k�rte", "szilva", "ban�n", "barack", "sz�l�"), 'a'));
    }
}