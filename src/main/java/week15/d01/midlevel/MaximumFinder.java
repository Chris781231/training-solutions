package week15.d01.midlevel;

import java.util.Map;

public class MaximumFinder {

    public Map.Entry<Double, Double> findMax(Map<Double, Double> values) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        Map.Entry<Double, Double> maxElement = null;

        for (Map.Entry<Double, Double> actualElement : values.entrySet()) {
            if (maxElement == null || actualElement.getValue() > maxElement.getValue()) {
                maxElement = actualElement;
            }
        }

        return maxElement;
    }
}
