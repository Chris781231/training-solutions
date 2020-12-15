package week08.d02.midlevel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {

    @Test
    void lotteryTest() {
        Lottery lottery = new Lottery();
        assertEquals("[16, 29, 38, 34, 45]", lottery.getNumbers().toString());

    }
}