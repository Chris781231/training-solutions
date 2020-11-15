package controlselection.consonant;

public class ToConsonant {

    public char convertToConsonant(char character) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        for (char vowel : vowels) {
            if (vowel == character) {
                return ++character;
            }
        }

        return character;
    }
}
