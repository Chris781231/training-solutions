package week05d04.midlevel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    private Store store = new Store();
    private Product p1;
    private Product p2;
    private Product p3;

    @BeforeEach
    void setUp() {
        p1 = new Product("Kenyér", 2020, 11, 26);
        store.addProduct(p1);
        p2 = new Product("UHT tej", 2020, 12, 1);
        store.addProduct(p2);
        p3 = new Product("Felvágott", 2020, 11, 25);
        store.addProduct(p3);
    }

    @Test
    void getNumberOfExpiredTest() {
        assertEquals(List.of(p3), store.getNumberOfExpired());
    }
}