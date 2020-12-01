package week06d02.midlevel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StoreTest {

    private Store store;

    @BeforeEach
    void setUp() {
        store = new Store();
        store.addProduct(new Product("milk", Category.DAIRY, 200));
        store.addProduct(new Product("sour cream", Category.DAIRY, 650));
        store.addProduct(new Product("cheese", Category.DAIRY, 1800));
        store.addProduct(new Product("bread", Category.BAKEDGOODS, 340));
        store.addProduct(new Product("buns", Category.BAKEDGOODS, 25));
        store.addProduct(new Product("Frozen vegetable mix", Category.FROZEN, 790));
    }

    @Test
    void getProductByCategoryNameTest() {
        assertEquals(3, store.getProductByCategoryName(Category.DAIRY));

        assertThrows(IllegalArgumentException.class, () -> store.getProductByCategoryName(null));
    }
}