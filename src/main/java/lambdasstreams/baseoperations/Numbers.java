package lambdasstreams.baseoperations;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Numbers {

    private List<Integer> numberList;

    public Numbers(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public Optional<Integer> min() {
        return numberList.stream()
                .min(Comparator.naturalOrder());
    }

    public int sum() {
        return numberList.stream()
                .reduce(0, (i1, i2) -> i1 + i2, Integer::sum);
    }

    public boolean isAllPositive() {
        return numberList.stream()
                .allMatch(i -> i > 0);
    }

    public List<Integer> getDistinctElements() {
        return numberList.stream()
                .distinct().collect(Collectors.toList());
    }
}
