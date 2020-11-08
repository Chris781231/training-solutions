package attributes.book;

public class BookMain {

    public static void main(String[] args) {

        Book book = new Book("Java Backend Development");

        System.out.printf("Title: %s\n", book.getTitle());
        book.setTitle("Junior Java Backend Development");
        System.out.printf("Title: %s\n", book.getTitle());
    }
}
