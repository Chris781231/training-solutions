package classstructureintegrate;

public class Product {

    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public void increasePrice(int plusPrice) {
        this.price += plusPrice;
    }

    public void decreasePrice(int minusPrice) {
        this.price -= minusPrice;
    }

}
