package collectionsequalshash;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookCatalogTest {

    private static final Book[] books = new Book[]{
            new Book("1212", "Egri Csillagok", "G�rdonyi G�za"),
            new Book("2121", "Vuk", "Fekete Istv�n"),
            new Book("4545", "Rab R�by", "J�kai M�r")
    };

    @Test
    public void findSelectedBookInBookList() {
        //When
        Book foundBook = new BookCatalog().findBookByTitleAuthor(Arrays.asList(books), "Vuk", "Fekete Istv�n");
        //Then
        assertEquals("2121", foundBook.getRegNumber());
        assertEquals("Fekete Istv�n", foundBook.getAuthor());
        assertEquals("Vuk", foundBook.getTitle());
        assertEquals("Book{regNumber='2121', title='Vuk', author='Fekete Istv�n'}", foundBook.toString());
    }

    @Test
    public void bookIsNotInBookList() {
        Book foundBook = new BookCatalog().findBookByTitleAuthor(Arrays.asList(books), "Vuk", "");

        assertEquals(null, foundBook);
    }

    @Test
    public void findSelectedBookInSearchableBookList() {
        //Given
        Book searchingFor = new Book("2121", "Vuk", "Fekete Istv�n");
        //When
        Book foundBook = new BookCatalog().findBook(Arrays.asList(books), searchingFor);
        //Then
        assertTrue(searchingFor.equals(foundBook));
    }

    @Test
    public void selectedBookIsNotInBookList() {
        Book searchingFor = new Book("2121", "Vuk", "Istv�n");

        Book foundBook = new BookCatalog().findBook(Arrays.asList(books), searchingFor);

        assertEquals(null, foundBook);
    }

    @Test
    public void findBookByTitleAndAuthor() {
        //Given
        Book searchingFor = new Book("Vuk", "Fekete Istv�n");
        //When
        Book foundBook = new BookCatalog().findBook(Arrays.asList(books), searchingFor);
        //Then
        assertTrue(searchingFor.equals(foundBook));
    }

    @Test
    public void addSameBooksToSet() {
        //Given
        Book[] sameBooks = new Book[]{
                new Book("1212", "Egri Csillagok", "G�rdonyi G�za"),
                new Book("1212", "Egri Csillagok", "G�rdonyi G�za"),
                new Book("1212", "Egri Csillagok", "G�rdonyi G�za")
        };
        //When
        Set<Book> bookSet = new BookCatalog().addBooksToSet(sameBooks);
        //Then
        assertEquals(1, bookSet.size());
    }
}