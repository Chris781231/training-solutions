package isahasa.htmldecorator.hasa;

import isahasa.htmldecorator.TextSource;

public abstract class TextDecorator implements TextSource {

    private final TextSource textSource;

    protected TextDecorator(TextSource textSource) {
        this.textSource = textSource;
    }

    public TextSource getTextSource() {
        return textSource;
    }
}
