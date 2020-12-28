package ioconvert.products;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class ProductWriter {

    public void saveProduct(OutputStream os, List<Product> products) {
        try (PrintStream out = new PrintStream(new BufferedOutputStream(os))) {
            for (Product product : products) {
                out.println(product.getName() + ";" + product.getPrice());
            }
        }
    }
}
