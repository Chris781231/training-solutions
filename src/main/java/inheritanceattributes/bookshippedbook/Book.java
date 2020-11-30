package inheritanceattributes.bookshippedbook;

public class Book {

    private final String title;
    protected int price;

    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int purchase(int pieces) {
        return price * pieces;
    }
}
