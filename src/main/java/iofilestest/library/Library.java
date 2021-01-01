package iofilestest.library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private final List<Book> books = new ArrayList<>();

    public void add(Book... books) {
        for (Book book : books) {
            if (!this.books.contains(book)) {
                this.books.add(book);
            }
        }
    }

    public void saveBooks(Path path) {
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Book book : this.books) {
                writer.write(book.getTitle());
                writer.write(";");
                writer.write(book.getAuthor());
                writer.newLine();
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot reach file", ioe);
        }
    }

    public void loadBooks(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(";");
                books.add(new Book(temp[0], temp[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }
}