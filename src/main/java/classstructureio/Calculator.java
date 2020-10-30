package classstructureio;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculator App\n");

        System.out.println("Give me a number: ");
        int num1 = scanner.nextInt();
        System.out.println("Give me an another number: ");
        int num2 = scanner.nextInt();
        int sum = num1 + num2;

        System.out.println("The result is following:");
        System.out.println(num1 + " + " + num2);
        System.out.println(sum);

    }

}
