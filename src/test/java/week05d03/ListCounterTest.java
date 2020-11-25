package week05d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListCounterTest {

    @Test
    void listCounterTest() {
        assertEquals(2, new ListCounter().listCounter(List.of("Alma", "ananász", "banán", "Körte")));
        assertEquals(0, new ListCounter().listCounter(List.of()));
        assertEquals(0, new ListCounter().listCounter(List.of("Banán", "körte")));

    }
}