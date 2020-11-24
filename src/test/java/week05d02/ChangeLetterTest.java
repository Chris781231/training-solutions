package week05d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeLetterTest {

    @Test
    void changeLettersTest() {
        assertEquals("H*ll* W*rld", new ChangeLetter().changeVowels("Hello World"));
    }

    void emptyParameterMustThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new ChangeLetter().changeVowels(null));
    }

}