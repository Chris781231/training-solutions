package collectionscomp;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class OrderedLibrary {

    private final List<Book> libraryBooks;

    public OrderedLibrary(List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public List<Book> orderedByTitle() {
        List<Book> orderedBooks = new ArrayList<>(libraryBooks);
        Collections.sort(orderedBooks);
        return orderedBooks;
    }

    public List<Book> orderedByAuthor() {
        List<Book> orderedBooks = new ArrayList<>(libraryBooks);
        orderedBooks.sort(new AuthorComparator());
        return orderedBooks;
    }

    public List<String> orderedByTitleLocale(Locale locale) {
        List<String> titles = new ArrayList<>();
        for (Book book : libraryBooks) {
            titles.add(book.getTitle());
        }
        Collator hunCollator = Collator.getInstance(locale);
        hunCollator.setStrength(Collator.PRIMARY);
        titles.sort(hunCollator);
        return titles;
    }

    public List<Book> getLibraryBooks() {
        return new ArrayList<>(libraryBooks);
    }
}
