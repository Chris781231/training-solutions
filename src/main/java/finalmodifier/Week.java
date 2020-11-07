package finalmodifier;

import java.util.Arrays;
import java.util.List;

public class Week {

    public final static List<String> DAYS = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");


    public static void main(String[] args) {

        System.out.println(DAYS.set(2, "Kedd"));
    }
}
