package introinheritance.itembasketshoppingbasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<Item> items = new ArrayList<>();

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

    public void clearBasket() {
        items.clear();
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
}
