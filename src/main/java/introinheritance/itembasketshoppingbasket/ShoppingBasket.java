package introinheritance.itembasketshoppingbasket;

public class ShoppingBasket {

    private Basket basket = new Basket();

    public void addItem(Item item) {
        basket.addItem(item);
    }

    public void removeItem(String barcode) {
        basket.removeItem(barcode);
    }

    public double sumNettoPrice() {
        int sum = 0;

        for (Item item: basket.getItems()) {
            sum += item.getNettoPrice();
        }

        return sum;
    }

    public double sumTaxValue() {
        int sum = 0;

        for (Item item : basket.getItems()) {
            sum += item.getTaxAmount();
        }

        return sum;
    }

    public double sumBruttoPrice() {
        return sumNettoPrice() + sumTaxValue();
    }

    public void checkout() {
        basket.clearBasket();
    }

    public void removeMostExpensiveItem() {
        Item mostExpensiveItem = null;

        for (Item item : basket.getItems()) {
            if (mostExpensiveItem == null || item.getNettoPrice() > mostExpensiveItem.getNettoPrice()) {
                mostExpensiveItem = item;
            }
        }

        removeItem(mostExpensiveItem.getBarcode());
    }
}
