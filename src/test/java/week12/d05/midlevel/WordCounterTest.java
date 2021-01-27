package week12.d05.midlevel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {

    @Test
    void wordCounter() {
        WordCounter wc = new WordCounter();
        assertEquals(10, wc.wordCounter());
        assertEquals(10, wc.wordCounter2());
    }
}