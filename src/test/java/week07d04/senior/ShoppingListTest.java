package week07d04.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingListTest {

    @Test
    void calculateSumTest() {
        assertEquals(800, new ShoppingList().calculateSum("/"));
    }
}
