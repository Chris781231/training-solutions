package inheritanceattributes.bookshippedbook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShippedBookTest {

    @Test
    public void constructorAndToStringTest() {
        //Given
        ShippedBook book = new ShippedBook("Gyűrűk ura", 3000, 1200);
        //Then
        assertEquals("Gyűrűk ura:3000 - 1200",book.toString());
    }

    @Test
    public void orderTest()  {
        //Given
        ShippedBook book = new ShippedBook("Gyűrűk ura", 3000, 1200);
        //Then
        assertEquals(7200,book.order(2));
    }

    @Test
    public void purchaseTest() {
        //Given
        ShippedBook book = new ShippedBook("Gyűrűk ura", 3000, 1200);
        //Then
        assertEquals(6000, book.purchase(2));
    }
}