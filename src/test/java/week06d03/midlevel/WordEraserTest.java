package week06d03.midlevel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordEraserTest {

    WordEraser wordEraser = new WordEraser();

    @Test
    void wordEraserTest() {
        String words = "Lorem ipsum dolor sit amet, libris ipsum putent perpetua ipsum ut mei, ipsum nam ut ipsum quis principes ipsum persecuti. Qui ne dicant graece inermis.";
        String word = "ipsum";

        assertEquals("Lorem dolor sit amet, libris putent perpetua ut mei, nam ut quis principes persecuti. Qui ne dicant graece inermis.",
                wordEraser.eraseWord(words, word));
    }

    @Test
    void nullCheckTest() {
        assertThrows(IllegalArgumentException.class, () -> wordEraser.eraseWord(null, "ipsum"));
        assertThrows(IllegalArgumentException.class, () -> wordEraser.eraseWord("Lorem ipsum dolor sit amet", null));
    }

    @Test
    void emptyCheckTest() {
        assertEquals("", wordEraser.eraseWord("", "ipsum"));
        assertEquals("Lorem ipsum dolor sit amet", wordEraser.eraseWord("Lorem ipsum dolor sit amet", ""));
    }
}