package week07d03.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateTest {
    Date date = Date.of(2020, 12, 31);

    @Test
    void dateTest() {
        assertEquals(2020, date.getYear());
        assertEquals(12, date.getMonth());
        assertEquals(31, date.getDay());
    }

    @Test
    void withYearTest() {
        assertEquals(2021, date.withYear(2021).getYear());
        assertEquals(9, date.withMonth(9).getMonth());
        assertEquals(1, date.withDay(1).getDay());
    }
}