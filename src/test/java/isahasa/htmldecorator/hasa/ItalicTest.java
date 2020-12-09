package isahasa.htmldecorator.hasa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItalicTest {

    @Test
    public void getPlainText() {
        TextSourceImplementation textSourceImplementation = new TextSourceImplementation("qwe");
        Italic italic = new Italic(textSourceImplementation);

        assertEquals("<i>qwe</i>", italic.getPlainText());
    }
}