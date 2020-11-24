package week05d02;

import java.util.List;

public class ChangeLetter {

    public String changeVowels(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("Parameter must not be empty!");
        }
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (!vowels.contains(str.charAt(i))) {
                sb.append(str.charAt(i));
            } else {
                int j = 0;
                while (!vowels.get(j).equals(str.charAt(i))) {
                    j++;
                }
                sb.append('*');
            }
        }

        return sb.toString();
    }
}
