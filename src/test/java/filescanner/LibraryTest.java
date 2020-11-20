package filescanner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTest {
    @Test
    public void testLoadFromFile() {
        Library library = new Library();

        library.loadFromFile2();

        assertEquals(4, library.getBooks().size());
        assertEquals("Robert C. Martin", library.getBooks().get(2).getAuthor());
    }
}