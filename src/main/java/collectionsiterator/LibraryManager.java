package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {

    private final Set<Book> books;

    public LibraryManager(Set<Book> books) {
        this.books = books;
    }

    public Book findBookByRegNumber(int regNumber) {
        Iterator<Book> iterator = this.books.iterator();
        while (iterator.hasNext()) {
            Book actualBook = iterator.next();
            if (actualBook.getRegNumber() == regNumber) {
                return actualBook;
            }
        }
        throw new MissingBookException(String.format("No books found with regnumber: %d", regNumber));
    }

    public int removeBookByRegNumber(int regNumber) {
        Iterator<Book> iterator = this.books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getRegNumber() == regNumber) {
                iterator.remove();
                return book.getRegNumber();
            }
        }
        throw new MissingBookException(String.format("No books found with regnumber: %d", regNumber));
    }

    public Set<Book> selectBooksByAuthor(String author) {
        Set<Book> result = new HashSet<>();
        Iterator<Book> iterator = this.books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        if (!result.isEmpty()) {
            return result;
        }
        throw new MissingBookException(String.format("No books found by %s", author));
    }

    public int libraryBooksCount() {
        return books.size();
    }

    public Set<Book> getBooks() {
        return new HashSet<>(books);
    }
}
