package week06d05;

import org.junit.jupiter.api.Test;
import week06d05.midlevel.Biscuit;
import week06d05.midlevel.BiscuitType;

import static org.junit.jupiter.api.Assertions.*;

class BiscuitTest {

    @Test
    void biscuitTest() {
        assertEquals("OREO (250)", Biscuit.of(BiscuitType.OREO, 250).toString());
    }
}