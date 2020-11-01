package statement;

import java.util.Scanner;

public class DivByThree {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Give me a number: ");
        int num = scanner.nextInt();

        boolean divisible = (num % 3 == 0);

        System.out.println("The number that given by you divisible by 3: " + divisible);

    }

}
