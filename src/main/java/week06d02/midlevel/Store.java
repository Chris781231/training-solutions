package week06d02.midlevel;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getProductByCategoryName(Category category) {

        if (category == null) {
            throw new IllegalArgumentException("Invalid category");
        }
        int count = 0;

        for (Product product : products) {
            if (product.getCategory() == category) {
                count++;
            }
        }

        return count;
    }
}
