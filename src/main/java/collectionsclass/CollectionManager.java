package collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionManager {

    private final List<Book> library;

    public CollectionManager(List<Book> library) {
        this.library = library;
    }

    public List<Book> createUnmodifiableLibrary() {
        return Collections.unmodifiableList(library);
    }
    public List<Book> reverseLibrary() {
        List<Book> reverseLibrary = new ArrayList<>(library);
        Collections.reverse(reverseLibrary);
        return reverseLibrary;
    }
    public Book getFirstBook() {
        List<Book> orderedLibrary = getOrderedLibrary();
        return orderedLibrary.get(0);
    }

    public Book getLastBook() {
        List<Book> orderedLibrary = getOrderedLibrary();
        return orderedLibrary.get(orderedLibrary.size() - 1);
    }

    private List<Book> getOrderedLibrary() {
        List<Book> orderedLibrary = new ArrayList<>(library);
        orderedLibrary.sort(Book::compareTo);
        return orderedLibrary;
    }

    public List<Book> getLibrary() {
        return new ArrayList<>(library);
    }
}
