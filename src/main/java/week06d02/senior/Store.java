package week06d02.senior;

import java.util.ArrayList;
import java.util.List;

public class Store {

    List<Product> products = new ArrayList<>();
    List<CategoryCounter> categoryCounters;

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<CategoryCounter> getProductByCategory() {
        categoryCounters = new ArrayList<>();
        int counter = 0;
        for (Category category : Category.values()) {
            buildNewCategoryCounter(categoryCounters, counter, category);
        }
        return categoryCounters;
    }

    private void buildNewCategoryCounter(List<CategoryCounter> categoryCounters, int counter, Category category) {
        for (Product product : products) {
            if (product.getCategory() == category) {
                counter++;
            }
        }
        categoryCounters.add(new CategoryCounter(category, counter));
    }
}
