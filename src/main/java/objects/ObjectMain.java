package objects;

public class ObjectMain {

    public static void main(String[] args) {

        new Book();
        System.out.println(new Book());

        Book emptyBook;
        emptyBook = null;
        System.out.println(emptyBook);

        System.out.println(emptyBook == null);

        Book book = emptyBook;
        System.out.println(book);

        book = null;
        System.out.println(book);

        book = new Book();
        System.out.println(book);

        Book anotherBook = new Book();
        System.out.println(book == anotherBook);

        anotherBook = book;
        System.out.println(book == anotherBook);

        System.out.println(anotherBook instanceof Book);
    }
}
