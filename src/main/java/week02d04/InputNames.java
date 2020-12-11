package week02d04;

import java.util.Scanner;

public class InputNames {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int arraySize = 5;
        String[] names = new String[arraySize];

        System.out.println("Give me " + arraySize + " names!");

        for (int i = 0; i < arraySize; i++) {
            System.out.print((i + 1) + ": ");
            names[i] = scanner.nextLine();
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}
