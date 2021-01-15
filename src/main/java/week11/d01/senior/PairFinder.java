package week11.d01.senior;

import java.util.ArrayList;
import java.util.List;

public class PairFinder {

    public int findPairs(int[] arr) {
        List<Integer> lonelyNumbers = new ArrayList<>();
        int count = 0;

        for (int number : arr) {
            if (!lonelyNumbers.contains(number)) {
                lonelyNumbers.add(number);
            } else {
                count++;
                lonelyNumbers.remove((Integer) number);
            }
        }

        return count;
    }
}
