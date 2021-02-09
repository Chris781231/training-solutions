package week14.d05.midlevel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {

    @Test
    void countWordsTest() {
        assertEquals(4,
                new WordCounter().countWords("hachiko.srt", "Hachiko", "haza", "pályaudvar", "jó").get("Hachiko"));
    }
}