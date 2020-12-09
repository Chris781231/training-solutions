package isahasa.htmldecorator.hasa;

import isahasa.htmldecorator.TextSource;

public class Italic extends TextDecorator {

    public Italic(TextSource textSource) {
        super(textSource);
    }

    @Override
    public String getPlainText() {
        return "<i>" + getTextSource().getPlainText() + "</i>";
    }
}
