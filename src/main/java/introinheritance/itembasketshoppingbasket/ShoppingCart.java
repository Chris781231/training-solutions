package introinheritance.itembasketshoppingbasket;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(String barcode) {
        for (Item item : items) {
            if (item.getBarcode().equals(barcode)) {
                items.remove(item);
                return;
            }
        }
    }

    public void checkout() {
        items.clear();
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public double sumNettoPrice() {
        int sum = 0;

        for (Item item: items) {
            sum += item.getNettoPrice();
        }

        return sum;
    }

    public double sumTaxValue() {
        int sum = 0;

        for (Item item : items) {
            sum += item.getTaxAmount();
        }

        return sum;
    }

    public double sumBruttoPrice() {
        return sumNettoPrice() + sumTaxValue();
    }

    public void removeMostExpensiveItem() {
        Item mostExpensiveItem = null;

        for (Item item : items) {
            if (mostExpensiveItem == null || item.getNettoPrice() > mostExpensiveItem.getNettoPrice()) {
                mostExpensiveItem = item;
            }
        }

        removeItem(mostExpensiveItem.getBarcode());
    }

}
