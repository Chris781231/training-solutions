package filescanner;

public class Book {

    private final String regNum;
    private final String author;
    private final String title;
    private final int yearOfPublish;

    public Book(String regNum, String author, String title, int yearOfPublish) {
        this.regNum = regNum;
        this.author = author;
        this.title = title;
        this.yearOfPublish = yearOfPublish;
    }

    public String getRegNum() {
        return regNum;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }
}
