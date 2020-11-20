package week04;

import java.util.ArrayList;
import java.util.List;

public class Search {

    public static void main(String[] args) {

        Search main = new Search();
        System.out.println(main.getIndexesOfChar("Himalája", 'a'));
    }

    List<Integer> getIndexesOfChar(String str, char c) {
        List<Integer> result = new ArrayList<>();

        int fromIndex = 0;
        while (str.indexOf(c, fromIndex) >= 0) {
            int indexOfChar = str.indexOf(c, fromIndex);
            result.add(indexOfChar);
            fromIndex = indexOfChar + 1;
        }

        return result;
    }
}
