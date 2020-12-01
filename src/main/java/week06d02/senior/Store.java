package week06d02.senior;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private final List<Product> products = new ArrayList<>();
    private List<StoredProductsByCategory> storedProductsByCategoryList;

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<StoredProductsByCategory> getProductByCategory() {
        createStoredProductsByCategory();

        for (Category category : Category.values()) {
            countProductsByCategory(category);
        }
        return storedProductsByCategoryList;
    }

    private void createStoredProductsByCategory() {
        storedProductsByCategoryList = new ArrayList<>();
        for (Category category : Category.values()) {
            storedProductsByCategoryList.add(new StoredProductsByCategory(category));
        }
    }

    private void countProductsByCategory(Category category) {
        StoredProductsByCategory actualStoredProduct = getActualStoredProduct(category);
        if (actualStoredProduct == null) {
            throw new IllegalStateException("Category must not be empty.");
        }

        for (Product product : products) {
            if (product.getCategory() == category) {
                actualStoredProduct.addAmount();
            }
        }
    }

    private StoredProductsByCategory getActualStoredProduct(Category category) {
        for (StoredProductsByCategory actualStoredProduct : storedProductsByCategoryList) {
            if (actualStoredProduct.getCategory() == category) {
                return actualStoredProduct;
            }
        }
        return null;
    }
}
