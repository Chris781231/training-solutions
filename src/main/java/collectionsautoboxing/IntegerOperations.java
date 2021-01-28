package collectionsautoboxing;

import java.util.ArrayList;
import java.util.List;

public class IntegerOperations {

    public List<Integer> createList(int... numbers) {
        List<Integer> nums = new ArrayList<>();

        for (int number : numbers) {
            nums.add(number);
        }

        return nums;
    }

    public int sumIntegerList(List<Integer> integerList) {
        int sum = 0;

        for (int number : integerList) {
            sum += number;
        }

        return sum;
    }

    public int sumIntegerObjects(Integer... integers) {
        int sum = 0;

        for (int number : integers) {
            sum += number;
        }

        return sum;
    }
}
