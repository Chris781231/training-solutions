package collectionslist.linkedlist;

import java.util.*;

public class Draw {

    public Set<Integer> drawNumbers(int drawCount, int maxNumber) {
        if (maxNumber <= drawCount) {
            throw new IllegalArgumentException("drawCount must be less then " + maxNumber + "!");
        }

        Queue<Integer> numbers = createNumberPool(maxNumber);
        Set<Integer> winningNumbers = new TreeSet<>();

        for (int i = 0; i < drawCount; i++) {
            winningNumbers.add(numbers.poll());
        }
        return winningNumbers;
    }

    private LinkedList<Integer> createNumberPool(int maxNumber) {
        LinkedList<Integer> numbers = new LinkedList<>();

        for (int i = 1; i <= maxNumber; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        return numbers;
    }
}
