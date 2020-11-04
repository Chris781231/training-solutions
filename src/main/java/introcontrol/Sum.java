package introcontrol;

import java.util.Scanner;

public class Sum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        System.out.println("Summary");

        for (int i = 0; i < 5; i++) {
            System.out.print("Give me a number: ");
            sum += scanner.nextInt();
        }
        System.out.println("Sum of the given numbers is " + sum);
    }
}
