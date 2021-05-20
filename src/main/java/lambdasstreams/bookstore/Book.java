package lambdasstreams.bookstore;

public class Book {

    // címével, kiadási évével, árával, darabszámával
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

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", yearOfPublish=" + yearOfPublish +
                ", price=" + price +
                ", numberOfBooks=" + numberOfBooks +
                '}';
    }
}
