package week08.d04.senior;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExamplesStoreTest {

    private ExamplesStore store;

    @BeforeEach
    void setUp() {
        store = new ExamplesStore();
    }

    @Test
    void getTitlesTest() {
        assertEquals(List.of("Első feladat", "Második feladat"), store.getTitlesOfExamples());
    }
}