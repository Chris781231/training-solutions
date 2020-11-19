package stringbuilder;

public class PalindromeValidator {
    public boolean isPalindrome(String s) {

        if (s == null) {
            throw new IllegalArgumentException("Text must not be null!");
        }

        if (s.isBlank()) {
            return true;
        }

        return s.equalsIgnoreCase(new StringBuilder(s).reverse().toString());
    }
}
