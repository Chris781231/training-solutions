package searching;

import java.util.Arrays;

public class BookArraySearch {

    private final Book[] books;

    public BookArraySearch(Book[] bookArray) {
        this.books = bookArray;
    }

    public Book findBookByAuthorTitle(String author, String title) {
        if (isEmpty(author) || isEmpty(title)) {
            throw new IllegalArgumentException("Author or title must not be empty!");
        }
        Book searchedBook = new Book(title, author);
        Arrays.sort(books);
        int idx = Arrays.binarySearch(books, searchedBook);
        if (idx < 0) {
            throw new IllegalArgumentException(String.format("No book found by %s with title %s", author, title));
        }
        return books[idx];
    }

    private boolean isEmpty(String s) {
        return s == null || s.isBlank();
    }
}
