package week06d01.senior;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SeparatedSumTest {

    String s;

    @AfterEach
    void tearDown() {
        s = null;
    }

    @Test
    void sumTest() {
        s = "100,5;200,4;-300,4;-500,15";
        SeparatedSumBySign sum = new SeparatedSum().sum(s);
        assertEquals(300.9, sum.getPositiveNum());
        assertEquals(-800.55, sum.getNegativeNum());
    }

    @Test
    void nullParameterOrEmptyStringShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new SeparatedSum().sum(null));
        assertThrows(IllegalArgumentException.class, () -> new SeparatedSum().sum(" \n\t "));
    }

}