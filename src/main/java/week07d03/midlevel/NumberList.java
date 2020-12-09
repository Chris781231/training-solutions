package week07d03.midlevel;

import java.util.List;

public class NumberList {

    public boolean isIncreasing(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) > numbers.get(i)) {
                return false;
            }
        }

        return true;
    }
}
