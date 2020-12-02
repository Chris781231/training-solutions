package week06d03.midlevel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordEraserTest {

    @Test
    void wordEraserTest() {
        WordEraser wordEraser = new WordEraser();
        String words = "Lorem ipsum dolor sit amet, libris ipsum putent perpetua ipsum ut mei, ipsum nam ut ipsum quis principes ipsum persecuti. Qui ne dicant graece inermis.";
        String word = "ipsum";

        assertEquals("Lorem dolor sit amet, libris putent perpetua ut mei, nam ut quis principes persecuti. Qui ne dicant graece inermis.",
                wordEraser.eraseWord(words, word));
    }
}