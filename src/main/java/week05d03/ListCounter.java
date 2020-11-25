package week05d03;

import java.util.List;

public class ListCounter {

    public int listCounter(List<String> strings) {
        int count = 0;

        for (String str : strings) {
            if (str.toLowerCase().charAt(0) == 'a') {
                count++;
            }
        }

        return count;
    }
}
