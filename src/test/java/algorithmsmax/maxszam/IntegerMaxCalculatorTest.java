package algorithmsmax.maxszam;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerMaxCalculatorTest {

    @Test
    void calculateMaxFromIntegerList() {
        assertEquals(762, new IntegerMaxCalculator().calculateMax(List.of(65, -57, 762, 3, 734, -839)));
    }

    @Test
    void testMax() {
        List<Integer> integers = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            integers.add(i % 30);
        }

        IntegerMaxCalculator test = new IntegerMaxCalculator();

        assertEquals(29, test.calculateMax(integers));

    }

}