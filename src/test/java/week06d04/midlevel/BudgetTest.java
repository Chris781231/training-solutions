package week06d04.midlevel;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BudgetTest {

    List<Item> items = List.of(
            new Item("Milk", 200, 12),
            new Item("Bread", 360, 12),
            new Item("Sour cream", 650, 11)
    );
    Budget budget = new Budget(items);

    @Test
    void getItemsByMonthTest() {
        assertEquals(2, budget.getItemsByMonth(12));
    }

    @Test
    void getItemsByMonthWrongParameterTest() {
        assertThrows(IllegalArgumentException.class, () -> budget.getItemsByMonth(13));
    }
}