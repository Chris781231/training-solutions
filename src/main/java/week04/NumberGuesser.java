package week04;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int rndNum = random.nextInt(100) + 1;
        int guess;

        System.out.println("Gondoltam egy számra 1 - 100 között!");

        do {
            System.out.print("Kérem a tipped: ");
            guess = Integer.parseInt(scanner.nextLine());
            if (rndNum < guess) {
                System.out.println("Kisebb");
            } else if (rndNum > guess) {
                System.out.println("Nagyobb");
            } else {
                System.out.println("Eltaláltad");
            }
        } while (rndNum != guess);
    }
}
