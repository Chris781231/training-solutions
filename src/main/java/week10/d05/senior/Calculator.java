package week10.d05.senior;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Egész számokat kérek egyesével, max. 100-t! Ha nem akarsz többet megadni, írj 0-t!");
        System.out.print(">> ");
        List<Integer> numberList = new ArrayList<>();
        int number;
        while ((number = Integer.parseInt(scanner.nextLine())) != 0) {
            numberList.add(number);
            System.out.print(">> ");
        }
        int[] numberArray = new int[numberList.size()];
        for (int i = 0; i < numberList.size(); i++) {
            numberArray[i] = numberList.get(i);
        }

        calculator.findMinMaxSum(numberArray);
    }

    public void findMinMaxSum(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Array is null");
        }
        if (numbers.length < 4) {
            throw new IllegalArgumentException("Too few elements are in array");
        }

        Arrays.sort(numbers);

        int minSum = 0;
        int maxSum = 0;
        for (int i = 0; i < 4; i++) {
            minSum += numbers[i];
            maxSum += numbers[numbers.length - i - 1];
            System.out.println(i + " " + minSum);
        }
        System.out.println("Min summary: " + minSum);
        System.out.println("Max summary: " + maxSum);
    }
}
