package week12.d03.midlevel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberStatTest {

    @Test
    void getOnesOccur() {
        NumberStat numberStat = new NumberStat();
        numberStat.readFromFile("numbers.txt");
        assertEquals(3, numberStat.getOnesOccur());
    }
}