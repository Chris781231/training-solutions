package week06d03.midlevel;

public class WordEraser {

    public String eraseWord(String words, String word) {
        StringBuilder changedWords = new StringBuilder();

        for (String wordsItem : words.split(" ")) {
            if (!wordsItem.toLowerCase().equals(word.toLowerCase())) {
                changedWords.append(wordsItem).append(" ");
            }
        }

        return changedWords.toString().strip();
    }
}
