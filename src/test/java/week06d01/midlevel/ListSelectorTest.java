package week06d01.midlevel;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ListSelectorTest {

    List<String> strings;

    @AfterEach
    void tearDown() {
        strings = null;
    }

    @Test
    void listSelectorTest() {
        strings = new ArrayList<>(List.of("alma", "körte", "barack", "szilva", "málna"));
        assertEquals("[alma, barack, málna]", new ListSelector().getEverySecondElement(strings));
    }

    @Test
    void nullListShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new ListSelector().getEverySecondElement(strings));
    }

    @Test
    void emptyListTest() {
        strings = new ArrayList<>();
        assertEquals("", new ListSelector().getEverySecondElement(strings));
    }
}