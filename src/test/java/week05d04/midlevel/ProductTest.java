package week05d04.midlevel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product p1;
    private Product p2;
    private Product p3;
    private Store store = new Store();

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
    void getNameTest() {
        assertEquals("Kenyér", p1.getName());
    }

    @Test
    void getExpireDateTest() {
        assertEquals(LocalDate.of(2020, 11, 25), p3.getExpireDate());
    }
}