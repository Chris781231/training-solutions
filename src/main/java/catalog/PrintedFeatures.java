package catalog;

import java.util.ArrayList;
import java.util.List;

import static catalog.Validators.isBlank;
import static catalog.Validators.isEmpty;


public class PrintedFeatures implements Feature {

    private final String title;
    private final int numberOfPages;
    private final List<String> authors;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if (isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        if (numberOfPages <= 0) {
            throw new IllegalArgumentException("Invalid number of pages: " + numberOfPages);
        }
        if (isEmpty(authors)) {
            throw new IllegalArgumentException("Empty authors");
        }
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.authors = authors;
    }

    @Override
    public List<String> getContributors() {
        return new ArrayList<>(authors);
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
