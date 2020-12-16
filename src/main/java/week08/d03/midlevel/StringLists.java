package week08.d03.midlevel;

import java.util.ArrayList;
import java.util.List;

public class StringLists {

    public List<String> stringListsUnion(List<String> first, List<String> second) {
        List<String> union = new ArrayList<>(first);

        for (String temp : second) {
            if (!first.contains(temp)) {
                union.add(temp);
            }
        }

        return union;
    }
}
