package inheritanceattributes.bookshippedbook;

public class ShippedBook extends Book {

    private final int shippingCost;

    public ShippedBook(String title, int price, int shippingCost) {
        super(title, price);
        this.shippingCost = shippingCost;
    }

    public int order (int pieces) {
        return pieces * price + shippingCost;
    }

    @Override
    public String toString() { // Gyűrűk ura:3000 - 1200
        return String.format("%s:%d - %d", getTitle(), price, shippingCost);
    }
}
