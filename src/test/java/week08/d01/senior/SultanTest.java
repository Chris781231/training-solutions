package week08.d01.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SultanTest {

    @Test
    void sultanTest() {
        Sultan sultan = new Sultan(100);
        assertTrue(sultan.openDoors(100).get(0).isOpen());
        assertFalse(sultan.openDoors(100).get(1).isOpen());
        assertTrue(sultan.openDoors(100).get(99).isOpen());
    }
}