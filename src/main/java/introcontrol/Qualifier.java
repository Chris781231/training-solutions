package introcontrol;

import java.util.Scanner;

public class Qualifier {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Give me a number: ");
        int num = scanner.nextInt();

        if (num > 100) {
            System.out.println("Greater than 100");
        } else {
            System.out.println("100 or smaller");
        }
    }
}
