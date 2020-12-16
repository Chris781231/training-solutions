package exceptionmulticatching.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerStatTest {

    BinaryStringConverter converter = new BinaryStringConverter();
    AnswerStat answerStat = new AnswerStat(converter);

    @Test
    void convertNullShouldThrowException() {
        InvalidBinaryStringException ibse = assertThrows(InvalidBinaryStringException.class,
                () -> answerStat.convert(null));
        assertTrue(ibse.getCause() instanceof NullPointerException);
    }

    @Test
    void convertInvalidStringShouldThrowException() {
        InvalidBinaryStringException ibse = assertThrows(InvalidBinaryStringException.class,
                () -> answerStat.convert("1133"));
        assertTrue(ibse.getCause() instanceof IllegalArgumentException);
    }

    @Test
    void convertShouldReturn() {

        assertEquals(7, new AnswerStat(new BinaryStringConverter()).convert("1100010").length);
        assertTrue(new AnswerStat(new BinaryStringConverter()).convert("1100010")[0]);
        assertTrue(new AnswerStat(new BinaryStringConverter()).convert("1100010")[1]);
        assertFalse(new AnswerStat(new BinaryStringConverter()).convert("1100010")[6]);
    }

    @Test
    void answerTruePercent() {
        assertEquals(50, new AnswerStat(new BinaryStringConverter()).answerTruePercent("11000101"));
        assertEquals(80, new AnswerStat(new BinaryStringConverter()).answerTruePercent("1111111100"));
    }
}