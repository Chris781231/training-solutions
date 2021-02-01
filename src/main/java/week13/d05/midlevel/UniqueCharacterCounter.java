package week13.d05.midlevel;

import java.util.Set;
import java.util.TreeSet;

public class UniqueCharacterCounter {

    public int getUniqueCharacterCount(String str) {
        Set<Character> characters = new TreeSet<>();
        String strToLowercase = str.toLowerCase();

        for (int i = 0; i < strToLowercase.length(); i++) {
            char temp = strToLowercase.charAt(i);
            if (temp >= 'a' && temp <= 'z') {
                characters.add(temp);
            }
        }

        return characters.size();
    }
}
