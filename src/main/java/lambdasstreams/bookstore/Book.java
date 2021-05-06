package lambdasstreams.bookstore;

public class Book {

    private String title;
    private int yearOfPublish;
    private int price;
    private int numberOfBooks;

    public Book(String title, int yearOfPublish, int price, int numberOfBooks) {
        this.title = title;
        this.yearOfPublish = yearOfPublish;
        this.price = price;
        this.numberOfBooks = numberOfBooks;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public int getPrice() {
        return price;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }
}
