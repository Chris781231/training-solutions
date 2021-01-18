package week11.d03.midlevel;

import java.util.ArrayList;
import java.util.List;

public class WordFilter {

    public List<String> wordWithChar(List<String> words, char c) {
        List<String> result = new ArrayList<>();
        String cString = Character.toString(c);
        for (String word : words) {
            if (word.contains(cString)) {
                result.add(word);
            }
        }
        return result;
    }
}
