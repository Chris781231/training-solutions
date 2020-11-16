package week04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NameChangerTest {

    @Test
    void invalidName() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new NameChanger(""));
        assertEquals("Invalid name: ", ex.getMessage());
    }

    @Test
    void nameChanging() {
        NameChanger nc = new NameChanger("Charlie Parker");
        nc.changeFirstName("Lucy");
        assertEquals("Lucy Parker", nc.getFullName());
    }
}
