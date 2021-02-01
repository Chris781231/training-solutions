package week13.d05.midlevel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueCharacterCounterTest {

    @Test
    void getUniqueCharacterCountTest() {
        String str = "hello, 4_á!\n";
        String str2 = "Írj egy metódust, amely megszámolja, hogy hány különböző betű van\n" +
                "egy szóban. A kis és nagybetűk közötti különbség nem számít!\n" +
                "A space-eket, számjegyeket, stb. ne vegye figyelembe! Csak az\n" +
                "angol ábécé betűit!";
        UniqueCharacterCounter counter = new UniqueCharacterCounter();

        assertEquals(4, counter.getUniqueCharacterCount(str));
        assertEquals(23, counter.getUniqueCharacterCount(str2));
    }
}