package week06d04.midlevel;

import java.util.ArrayList;
import java.util.List;

public class Budget {

    private final List<Item> items;

    public Budget(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public int getItemsByMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        int countOfItems = 0;

        for (Item item : items) {
            if (item.getMonth() == month) {
                countOfItems++;
            }
        }

        return countOfItems;
    }
}
