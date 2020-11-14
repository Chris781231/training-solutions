package numbers;

import java.util.Scanner;

public class MathOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String example = "3 * (2 + 1) / 6 - 1";
        double result = 3.0 * (2 + 1) / 6 - 1;

        System.out.println("Calculate the following example!");
        System.out.printf("%s = ", example);
        double resultOfUser = Double.parseDouble(scanner.nextLine());
        double resultOfComputer = result;

        System.out.println(Math.abs(resultOfUser - resultOfComputer) < 0.000001 ? "Correct" : "Not correct");
    }
}
