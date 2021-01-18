package week11.d03.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharCounterTest {

    @Test
    void countChars() {

        CharCounter charCounter = new CharCounter();
        String[] chars = new String[3];
        chars[0] = "abc";
        chars[1] = "cba";
        chars[2] = "ab";
        assertEquals(2, charCounter.countChars(chars));
    }
}