package week06d03.midlevel;

public class WordEraser {

    public String eraseWord(String words, String word) {
        if (words == null || word == null) {
            throw new IllegalArgumentException("Parameters of eraseWord must not be null!");
        }
        if (words.isBlank() || word.isBlank()) {
            return words;
        }

        StringBuilder changedWords = new StringBuilder();

        for (String wordsItem : words.split(" ")) {
            if (!wordsItem.toLowerCase().equals(word.toLowerCase())) {
                changedWords.append(wordsItem).append(" ");
            }
        }

        return changedWords.toString().strip();
    }
}
