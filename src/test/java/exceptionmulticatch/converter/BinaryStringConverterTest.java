package exceptionmulticatch.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryStringConverterTest {

    BinaryStringConverter converter = new BinaryStringConverter();

    @Test
    void binaryStringToBooleanArrayShouldInvalidStringThrowException() {
        assertThrows(IllegalArgumentException.class, () -> converter.binaryStringToBooleanArray("011200"));
    }

    @Test
    void binaryStringToBooleanArrayShouldConvert() {
        String binaryString = "0111001";

        assertEquals(binaryString.length(), converter.binaryStringToBooleanArray(binaryString).length);
        assertFalse(converter.binaryStringToBooleanArray(binaryString)[0]);
        assertTrue(converter.binaryStringToBooleanArray(binaryString)[binaryString.length() - 1]);
    }

    @Test
    void booleanArrayToBinaryStringShouldEmptyArrayThrowException() {
        assertThrows(IllegalArgumentException.class, () -> converter.booleanArrayToBinaryString(new boolean[0]));
    }

    @Test
    void booleanArrayToBinaryStringShouldConvert() {
        boolean[] booleans = new boolean[] {false, true, true, false, false};

        assertEquals("01100", converter.booleanArrayToBinaryString(booleans));
    }
}