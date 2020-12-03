package week06d04.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void addItemTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem("Bread", 2);
        shoppingCart.addItem("Milk", 2);
        shoppingCart.addItem("Milk", 10);

        assertEquals(2, shoppingCart.getItems().size());
        assertEquals(12, shoppingCart.getItem("Milk"));
    }
}