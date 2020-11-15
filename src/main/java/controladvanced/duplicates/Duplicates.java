package controladvanced.duplicates;

import java.util.ArrayList;
import java.util.List;

public class Duplicates {

    public List<Integer> find(List<Integer> numbers) {
        List<Integer> duplicatedNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {

            // Is item already in the `duplicatedNumbers` list?
//            if (duplicatedNumbers.contains(numbers.get(i))) {
//                continue;
//            }

            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    duplicatedNumbers.add(numbers.get(i));
                    break;
                }
            }
        }

        return duplicatedNumbers;
    }
}
