package week04d02;

import java.util.ArrayList;
import java.util.List;

public class Search {

    public static void main(String[] args) {

        Search main = new Search();
        System.out.println(main.getIndexesOfChar("Himalája", 'a'));
        System.out.println(main.getPositionsOfChars("aaaa", "aa"));
        System.out.println(main.getPositionsOfChars("aaaa", "aaa"));
    }

    public List<Integer> getIndexesOfChar(String str, char c) {
        List<Integer> result = new ArrayList<>();

        int fromIndex = 0;
        while (str.indexOf(c, fromIndex) >= 0) {
            int indexOfChar = str.indexOf(c, fromIndex);
            result.add(indexOfChar);
            fromIndex = indexOfChar + 1;
        }

        return result;
    }

    public List<Integer> getPositionsOfChars(String base, String part) {
        List<Integer> result = new ArrayList<>();
        int startIndex = 0;
        int index = 0;

        while ((index = base.indexOf(part, startIndex)) >= 0) {
            result.add(index);
            startIndex = ++index;
        }
        return result;
    }
}
