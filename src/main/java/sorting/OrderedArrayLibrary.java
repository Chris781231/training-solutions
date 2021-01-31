package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class OrderedArrayLibrary {

    private final Book[] books;

    public OrderedArrayLibrary(Book[] books) {
        this.books = books;
    }

    public Book[] sortingById() {
        Book[] result = books;

        Arrays.sort(result);

        return result;
    }

    public Book[] sortingByTitle() {
        Book[] result = books;

        Arrays.sort(books, new Comparator<>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

        return result;
    }
}
