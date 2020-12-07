package interfacestaticmethods;

public class Product implements Valued {

    private final String name;
    private final double value;

    public Product(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getValued() {
        return value;
    }
}
