package week11.d04.senior;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameLength {

    public Set<Integer> getLengths(List<String> names) {
        Set<Integer> lengthsOfJNames = new HashSet<>();

        for (String name : names) {
            if (name.startsWith("J")) {
                lengthsOfJNames.add(name.length());
            }
        }

        return lengthsOfJNames;
    }
}
