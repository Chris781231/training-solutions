package week11.d03.senior;

import java.util.ArrayList;
import java.util.List;

public class CharCounter {

    public int countChars(String[] chars) {
        List<String> sameChars = new ArrayList<>();
        for (int i = 0; i < chars[0].length(); i++) {
            if (!sameChars.contains(String.valueOf(chars[0].charAt(i)))) {
                sameChars.add(String.valueOf(chars[0].charAt(i)));
            }
        }
        for (String word : chars) {
            sameChars.removeIf(sameChar -> !word.contains(sameChar));
        }
        return sameChars.size();
    }
}
