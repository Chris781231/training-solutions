package week05d04.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void convertPriceTest() {
        Product p1 = new Product(150, Currency.HUF);
        Product p2 = new Product(10, Currency.USD);

        assertEquals(0.5, p1.convertPrice(Currency.USD));
        assertEquals(150, p1.convertPrice(Currency.HUF));
        assertEquals(3000, p2.convertPrice(Currency.HUF));
    }
}