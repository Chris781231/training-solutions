package objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


        // Arrays and Collections
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book[] booksArray = {book1, book2, book3};

        List<Book> booksList = Arrays.asList(book1, book2, book3);

        List<Book> anotherBooksList = new ArrayList<>();
        anotherBooksList.add(book1);
        anotherBooksList.add(book2);
        anotherBooksList.add(book3);
    }
}
