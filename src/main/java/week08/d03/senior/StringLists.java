package week08.d03.senior;

import java.util.ArrayList;
import java.util.List;

public class StringLists {

    public List<String> getShortestWords(List<String> strings) {
        checkStringParam(strings);
        int shortestWordLength = findShortestWordLength(strings);
        List<String> shortestWords = new ArrayList<>();

        for (String word : strings) {
            if (word.length() == shortestWordLength) {
                shortestWords.add(word);
            }
        }

        return shortestWords;
    }

    private int findShortestWordLength(List<String> strings) {
        int shortestWordLength = Integer.MAX_VALUE;

        for (String word : strings) {
            if (word.length() < shortestWordLength) {
                shortestWordLength = word.length();
            }
        }

        return shortestWordLength;
    }

    private void checkStringParam(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("Null or empty parameter");
        }
    }
}
