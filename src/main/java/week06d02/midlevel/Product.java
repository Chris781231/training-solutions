package week06d02.midlevel;

public class Product {

    private final String name;
    private final Category category;
    private final int price;

    public Product(String name, Category category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%12s -> %20s - %4d Ft)%n", category, name, price);
    }
}
