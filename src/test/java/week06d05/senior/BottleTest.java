package week06d05.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BottleTest {

    @Test
    void bottleFillTest() {
        Bottle bottle = Bottle.of(BottleType.GLASS_BOTTLE);
        bottle.fill(200);

        assertEquals(200, bottle.getFilledUntil());
        assertEquals(130, bottle.getType().getMaximumAmount() - bottle.getFilledUntil());
    }

    @Test
    void bottleOverFillTest() {
        Bottle bottle = Bottle.of(BottleType.PET_BOTTLE);
        bottle.fill(500);

        assertEquals(0, bottle.getType().getMaximumAmount() - bottle.getFilledUntil());
        assertThrows(IllegalArgumentException.class, () -> bottle.fill(1));
    }
}