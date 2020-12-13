package catalog;

import java.util.ArrayList;
import java.util.List;

import static catalog.Validators.isBlank;
import static catalog.Validators.isEmpty;

public class AudioFeatures implements Feature {

    private final String title;
    private final int length;
    private final List<String> performers;
    private final List<String> composers;

    public AudioFeatures(String title, int length, List<String> performers) {
        this(title, length, performers, new ArrayList<>());
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composers) {
        if (isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        if (length <= 0) {
            throw new IllegalArgumentException("Invalid length: " + length);
        }
        if (isEmpty(performers)) {
            throw new IllegalArgumentException("Empty performers");
        }
        if (composers == null) {
            throw new IllegalArgumentException("Composers is null");
        }
        this.title = title;
        this.length = length;
        this.performers = performers;
        this.composers = composers;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>(composers);
        contributors.addAll(performers);
        return contributors;
    }
}
