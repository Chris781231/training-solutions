package isahasa.htmldecorator.isa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItalicAndBoldHtmlTextTest {

    @Test
    public void getBytes() throws Exception {
        ItalicAndBoldHtmlText italicAndBoldHtmlText = new ItalicAndBoldHtmlText("asd");

        assertEquals("<i><b>asd</b></i>", italicAndBoldHtmlText.getPlainText());
    }
}