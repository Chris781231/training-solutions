package ioreadbytes.byteacount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ByteCheckerTest {

    ByteChecker byteChecker = new ByteChecker();


    @Test
    public void readBytesAndFindAsTest() {

        assertEquals(129, byteChecker.readBytesAndFindAs("data.dat"));
    }
}