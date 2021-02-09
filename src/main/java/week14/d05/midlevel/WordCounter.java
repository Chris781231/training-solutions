package week14.d05.midlevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    private final Map<String, Integer> wordCounts = new HashMap<>();

    public static void main(String[] args) {
        WordCounter wc = new WordCounter();
        Map<String, Integer> wordCounts = wc.countWords("hachiko.srt", "Hachiko", "haza",
                "pályaudvar", "jó");
        System.out.println(wordCounts);
    }

    public Map<String, Integer> countWords(String path, String... searchedWords) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(WordCounter.class.getResourceAsStream(path), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line, searchedWords);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

        return wordCounts;
    }

    private void processLine(String line, String[] searchedWords) {
        for (String word : searchedWords) {
            if (line.contains(word)) {
                addValueToMap(word);
            }
        }
    }

    private void addValueToMap(String word) {
        if (!wordCounts.containsKey(word)) {
            wordCounts.put(word, 1);
        } else {
            int value = wordCounts.get(word);
            wordCounts.put(word, ++value);
        }
    }
}
