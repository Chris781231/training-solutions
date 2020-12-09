package isahasa.htmldecorator.isa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItalicHtmlTextTest {

    @Test
    public void getBytes() throws Exception {
        ItalicHtmlText italicHtmlText = new ItalicHtmlText("asd");

        assertEquals("<i>asd</i>", italicHtmlText.getPlainText());
    }
}