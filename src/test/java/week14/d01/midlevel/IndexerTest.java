package week14.d01.midlevel;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IndexerTest {

    @Test
    void indexTest() {
        String[] names = {"Odon", "Lujza", "Abraham", "Magdolna", "Márk"};
        assertEquals("{A=[Abraham], L=[Lujza], M=[Magdolna, Márk], O=[Odon]}", new Indexer().index(Arrays.asList(names)).toString());
    }
}