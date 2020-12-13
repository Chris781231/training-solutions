package catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogItem {

    private final String registrationNumber;
    private final int price;
    private final List<Feature> features = new ArrayList<>();

    public CatalogItem(String registrationNumber, int price, Feature... features) {
        this.registrationNumber = registrationNumber;
        this.price = price;
        this.features.addAll(List.of(features));
    }

    public int fullLengthAtOneItem() {
        int sum = 0;

        for (Feature feature : features) {
            if (feature instanceof AudioFeatures) {
                sum += ((AudioFeatures) feature).getLength();
            }
        }

        return sum;
    }

    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();

        for (Feature feature : features) {
            contributors.addAll(feature.getContributors());
        }

        return contributors;
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();

        for (Feature feature : features) {
            titles.add(feature.getTitle());
        }

        return titles;
    }

    public boolean hasAudioFeature() {
        for (Feature feature : features) {
            if (feature instanceof AudioFeatures) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPrintedFeature() {
        for (Feature feature : features) {
            if (feature instanceof PrintedFeatures) {
                return true;
            }
        }
        return false;
    }

    public int numberOfPagesAtOneItem() {
        int sum = 0;

        for (Feature feature : features) {
            if (feature instanceof PrintedFeatures) {
                sum += ((PrintedFeatures) feature).getNumberOfPages();
            }
        }

        return sum;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getPrice() {
        return price;
    }

    public List<Feature> getFeatures() {
        return new ArrayList<>(features);
    }
}
