package searching;

public class Book implements Comparable<Book> {

    private int id;
    private final String author;
    private final String title;

    public Book(int id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return id + " " + author + " " + title;
    }

    @Override
    public int compareTo(Book o) {
        if (this.author.compareTo(o.author) != 0) {
            return this.author.compareTo(o.author);
        }
        return this.title.compareTo(o.title);
    }
}
