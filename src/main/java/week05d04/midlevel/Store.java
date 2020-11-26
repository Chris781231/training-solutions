package week05d04.midlevel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getNumberOfExpired() {
        List<Product> numberOfExpired = new ArrayList<>();

        for (Product product : products) {
            if (product.getExpireDate().isBefore(LocalDate.now())) {
                numberOfExpired.add(product);
            }
        }

        return numberOfExpired;
    }
}
