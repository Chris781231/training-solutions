package interfacedefaultmethods;

public class ColoredPage {

    private final String page;
    private final String color;

    public ColoredPage(String page, String color) {
        this.page = page;
        this.color = color;
    }

    public ColoredPage(String page) {
        this(page, Printable.BLACK);
    }

    public String getPage() {
        return page;
    }

    public String getColor() {
        return color;
    }
}
