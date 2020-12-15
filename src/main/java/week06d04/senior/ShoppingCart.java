package week06d04.senior;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Item> items = new ArrayList();

    public void addItem(String name, int quantity) {
        if (isEmpty(name) || quantity <= 0) {
            throw new IllegalArgumentException("One of parameter is invalid!");
        }

        Item item = getItemByName(name);

        if (item == null) {
            items.add(new Item(name, quantity));
        } else {
            item.addQuantity(quantity);
        }
    }

    private boolean isEmpty(String name) {
        return name == null || name.isBlank();
    }

    public int getItem(String name) {
        Item item = getItemByName(name);
        return item == null ? 0 : item.getQuantity();
    }

    private Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
}
