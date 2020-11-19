package stringscanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringScanner {

    public int readAndSumValues(String intString, String delimiter) {

        int sum = 0;

        try (Scanner scanner = new Scanner(intString)) {
            if (!isEmpty(delimiter)) {
                scanner.useDelimiter(delimiter);
            }

            while (scanner.hasNext()) {
                try {
                    sum += scanner.nextInt();
                } catch (InputMismatchException ime) {
                    throw new IllegalArgumentException("Incorrect parameter string!");
                }
            }
        }
        return sum;
    }

    public int readAndSumValues(String intString) {

        return readAndSumValues(intString, null);
    }

    public String filterLinesWithWordOccurrences(String text, String word) {

        if (isEmpty(text) || word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }

        StringBuilder sb;
        try (Scanner scanner = new Scanner(text)) {
            sb = new StringBuilder();

            while (scanner.hasNextLine()) {
                String textLine = scanner.nextLine();
                if (textLine.contains(word)) {
                    sb.append(textLine).append("\n");
                }
            }
        }
        return sb.toString().stripTrailing();
    }

    private boolean isEmpty(String s) {
        return s == null || s.isBlank();
    }
}
