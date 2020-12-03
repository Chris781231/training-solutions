package week06d04.senior;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Item> items = new ArrayList();

    public void addItem(String name, int quantity) {
        if (isEmpty(name) || quantity <= 0) {
            throw new IllegalArgumentException("One of parameter is invalid!");
        }

        for (Item item : items) {
            if (item.getName().equals(name)) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new Item(name, quantity));
    }

    private boolean isEmpty(String name) {
        return name == null || name.isBlank();
    }

    public int getItem(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item.getQuantity();
            }
        }
        return 0;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
}
