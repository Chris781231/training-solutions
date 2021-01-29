package statements;

import java.util.Scanner;

public class TimeMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Time App\n");

        // First time
        System.out.println("Give me a time...");
        System.out.print("Hour: ");
        int time1Hour = scanner.nextInt();
        System.out.print("Minutes: ");
        int time1Minute = scanner.nextInt();
        System.out.print("Second: ");
        int time1Second = scanner.nextInt();

        // Second time
        System.out.println("Give me another time...");
        System.out.print("Hour: ");
        int time2Hour = scanner.nextInt();
        System.out.print("Minutes: ");
        int time2Minute = scanner.nextInt();
        System.out.print("Second: ");
        int time2Second = scanner.nextInt();

        Time time1 = new Time(time1Hour, time1Minute, time1Second);
        Time time2 = new Time(time2Hour, time2Minute, time2Second);

        System.out.println("First time " + time1 + " = " + time1.getInMinutes() + " minutes");
        System.out.println("Second time " + time2 + " = " + time2.getInSeconds() + " seconds");
        System.out.println("The first earlier than second: " + time1.earlierThan(time2));

    }

}
