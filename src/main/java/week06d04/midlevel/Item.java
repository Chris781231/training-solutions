package week06d04.midlevel;

public class Item {

    private final String name;
    private final int price;
    private final int month;

    public Item(String name, int price, int month) {
        this.name = name;
        this.price = price;
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getMonth() {
        return month;
    }
}
