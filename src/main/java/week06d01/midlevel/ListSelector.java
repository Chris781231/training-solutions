package week06d01.midlevel;

import java.util.List;

public class ListSelector {

    public String getEverySecondElement(List<String> stringElements) {
        if (!isValid(stringElements)) {
            throw new IllegalArgumentException("The list must not be null!");
        }

        if (stringElements.isEmpty()) {
            return "";
        }

        return buildString(stringElements);
    }

    private String buildString(List<String> stringElements) {
        StringBuilder everySecondElement = new StringBuilder();
        everySecondElement.append("[");

        for (int i = 0; i < stringElements.size(); i += 2) {
            everySecondElement.append(stringElements.get(i));
            everySecondElement.append(", ");
        }

        everySecondElement.delete(everySecondElement.lastIndexOf(", "), everySecondElement.length());
        everySecondElement.append("]");

        return everySecondElement.toString();
    }

    private boolean isValid(List<String> stringElements) {
        return stringElements != null;
    }
}
