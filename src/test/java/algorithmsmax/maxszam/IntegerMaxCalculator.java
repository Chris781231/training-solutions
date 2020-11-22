package algorithmsmax.maxszam;

import java.util.List;

public class IntegerMaxCalculator {

    public int calculateMax(List<Integer> numbers) {
        int max = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }

        return max;
    }
}
