package iofilestest.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryTest {

    @TempDir
    File temporaryFolder;
    Path file = new File(temporaryFolder, "library.txt").toPath();

    @BeforeEach
    void setUp() {
        Book[] books = new Book[]{
                new Book("Lord of The Rings: Two Towers", "J. R. R. Tolkien"),
                new Book("Harry Potter and Sorcerers' Stone", "J. K. Rowling")
        };
        Library library = new Library();
        library.add(books);
        library.saveBooks(file);
    }

    @Test
    void saveBooksTest() throws IOException {
        List<String> content = Files.readAllLines(file);
        assertEquals(2, content.size());
        assertTrue(content.get(0).contains("Lord of The Rings"));
    }

}