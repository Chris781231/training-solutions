package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        for (CatalogItem item: catalogItems) {
            if (item.getRegistrationNumber().equals(catalogItem.getRegistrationNumber())) {
                throw new IllegalArgumentException("The Catalog contains such an item with this registration number: " + catalogItem.getRegistrationNumber());
            }
        }
        catalogItems.add(catalogItem);
    }

    public double averagePageNumberOver(int pageNumber) {
        if (pageNumber <= 0) {
            throw new IllegalArgumentException("Page number must be positive");
        }
        int sum = 0;
        int count = 0;

        for (CatalogItem catalogItem : catalogItems) {
            int numberOfPages = catalogItem.numberOfPagesAtOneItem();
            if (numberOfPages > pageNumber) {
                sum += numberOfPages;
                count++;
            }
        }
        if (count == 0) {
            throw new IllegalArgumentException("No page");
        }
        return 1.0 * sum / count;
    }

    public void deleteItemByRegistrationNumber(String registrationNumber) {
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.getRegistrationNumber().equals(registrationNumber)) {
                catalogItems.remove(catalogItem);
                return;
            }
        }
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> result = new ArrayList<>();

        if (searchCriteria.hasTitle() && searchCriteria.hasContributor()) {
            fillListByTitlesAndContributors(searchCriteria, result);
        } else if (searchCriteria.hasTitle()) {
            fillListByTitles(searchCriteria, result);
        } else {
            fillListByContributors(searchCriteria, result);
        }

        return result;
    }

    private void fillListByTitlesAndContributors(SearchCriteria searchCriteria, List<CatalogItem> result) {
        for (CatalogItem catalogItem : this.catalogItems) {
            if (catalogItem.getTitles().contains(searchCriteria.getTitle()) &&
                    catalogItem.getContributors().contains(searchCriteria.getContributor())) {
                result.add(catalogItem);
            }
        }
    }

    private void fillListByTitles(SearchCriteria searchCriteria, List<CatalogItem> result) {
        for (CatalogItem catalogItem : this.catalogItems) {
            if (catalogItem.getTitles().contains(searchCriteria.getTitle())) {
                result.add(catalogItem);
            }
        }
    }

    private void fillListByContributors(SearchCriteria searchCriteria, List<CatalogItem> result) {
        for (CatalogItem catalogItem : this.catalogItems) {
            if (catalogItem.getContributors().contains(searchCriteria.getContributor())) {
                result.add(catalogItem);
            }
        }
    }

    public int getAllPageNumber() {
        int sum = 0;

        for (CatalogItem catalogItem : catalogItems) {
            sum += catalogItem.numberOfPagesAtOneItem();
        }

        return sum;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> audioLibraryItems = new ArrayList<>();

        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasAudioFeature()) {
                audioLibraryItems.add(catalogItem);
            }
        }

        return audioLibraryItems;
    }

    public int getFullLength() {
        int sum = 0;

        for (CatalogItem catalogItem : catalogItems) {
            sum += catalogItem.fullLengthAtOneItem();
        }

        return sum;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> printedLibraryItems = new ArrayList<>();

        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasPrintedFeature()) {
                printedLibraryItems.add(catalogItem);
            }
        }

        return printedLibraryItems;
    }
}
