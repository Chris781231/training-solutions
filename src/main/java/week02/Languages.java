package week02;

import java.util.ArrayList;
import java.util.List;

public class Languages {

    public static void main(String[] args) {
        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("JavaScript");

        List<String> largerThanFiveChars = new ArrayList<>();

        for (String language : languages) {
            if (language.length() > 5) {
                largerThanFiveChars.add(language);
            }
        }

        System.out.println(largerThanFiveChars);
    }
}
