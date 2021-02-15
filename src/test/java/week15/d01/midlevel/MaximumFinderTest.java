package week15.d01.midlevel;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumFinderTest {

    @Test
    public void findFunctionMaximumTest() {
        MaximumFinder finder = new MaximumFinder();

        Map<Double, Double> function = new HashMap<>();
        function.put(-2.0, -1.0);
        function.put(-1.0, -7.0);
        function.put(0.0, -1.0);
        function.put(1.0, 0.0);
        function.put(2.0, -0.5);
        function.put(3.0, -1.0);

        Map.Entry<Double, Double> result = finder.findMax(function);
        assertEquals(1.0, result.getKey());
        assertEquals(0.0, result.getValue());
    }
}