package formatlocaleprintf;

import java.util.Locale;
import java.util.MissingFormatArgumentException;

public class PrintFormat {
    
    public String formatMessageWithIntegerParameters(String formatString, Integer i, Integer j) {
        try {
            return String.format(new Locale("hu", "HU"),formatString, i, j);
        } catch (MissingFormatArgumentException mfae) {
            throw new IllegalArgumentException("Less objects then expected in format String!");
        }
    }

    public String printFormattedText(Double number) {
        return String.format(new Locale("hu", "HU"), "Total is: %,.2f Ft", number); // ',' is a flag that means the result will include locale-specific grouping separators
    }

    public String printFormattedText(int number) {
        return String.format(new Locale("hu", "HU"), "Right edge of numbers set at 4 spaces from text:%4d", number);
    }

    public String printFormattedText(int count, String str) {
        return String.format(new Locale("hu", "HU"), "We counted %d %s in the basket", count, str);
    }

    public String printFormattedText(Integer i, Integer j, Integer k) {
        return String.format(new Locale("hu", "HU"), "Multiple objects containing text:%d\t%d\t%d", i, j, k);
    }

    public static void main(String[] args) {
        new PrintFormat().formatMessageWithIntegerParameters("%d  %d  %d", 6, 7);
    }
}
