package filescanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    List<Book> books = new ArrayList<>();

    public void loadFromFile() {
        try (Scanner scanner = new Scanner(Library.class.getResourceAsStream("/books.csv"))) {
            scanner.useDelimiter(";|(\r\n)|\n");
            while (scanner.hasNextLine()) {
                books.add(new Book(scanner.next(), scanner.next(), scanner.next(), scanner.nextInt()));
            }
        }

    }

    public List<Book> getBooks() {
        return books;
    }
}
