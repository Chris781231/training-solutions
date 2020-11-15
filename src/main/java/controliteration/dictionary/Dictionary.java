package controliteration.dictionary;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    private List<DictionaryItem> dictionaryItems = new ArrayList<>();

    public void addItem(String word, List<String> translations) {
        if (dictionaryItems.isEmpty()) {
            dictionaryItems.add(new DictionaryItem(word, translations));
        } else {
            for (DictionaryItem item : dictionaryItems) {
                if (!item.getWord().equals(word)) {
                    dictionaryItems.add(new DictionaryItem(word, translations));
                } else {
                    item.addTranslations(translations);
                }
            }
        }
    }

    public List<String> findTranslations(String word) {
        for (DictionaryItem translations : dictionaryItems) {
            if (translations.getWord().equals(word)) {
                return translations.getTranslations();
            }
        }
        return null;
    }
}
