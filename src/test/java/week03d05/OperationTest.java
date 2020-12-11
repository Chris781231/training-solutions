package week03d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperationTest {

    @Test
    void testGetResult() {
        assertEquals(8, new Operation("3+5").getResult());
        assertEquals(30, new Operation(" 14 + 16 ").getResult());
    }

    @Test
    void emptyOrContainsOnlyWhiteSpaceLiteralShouldThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Operation(" \n\t"));
        ex = assertThrows(IllegalArgumentException.class, () -> new Operation(""));
    }

    @Test
    void literalThatNotContainsPlusSignShouldThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Operation("3-5"));
        ex = assertThrows(IllegalArgumentException.class, () -> new Operation("35"));
    }
}