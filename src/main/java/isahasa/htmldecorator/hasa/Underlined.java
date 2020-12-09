package isahasa.htmldecorator.hasa;

import isahasa.htmldecorator.TextSource;

public class Underlined extends TextDecorator {

    public Underlined(TextSource textSource) {
        super(textSource);
    }

    @Override
    public String getPlainText() {
        return "<u>" + getTextSource().getPlainText() + "</u>";
    }
}
