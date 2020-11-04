package introcontrol;

import java.util.Scanner;

public class BoatRental {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Boat Rental\n");
        System.out.print("How many people want to sailing? ");
        int sum = scanner.nextInt();

        if (sum <= 2) {
            System.out.println("The two-person boat was taken. 8 people can go, yet.");
        } else if (sum == 3) {
            System.out.println("The three-person boat was taken. 7 people can go, yet.");
        } else if (sum <= 5) {
            System.out.println("The five-person boat was taken. 5 people can go, yet.");
        } else if (sum <= 7) {
            System.out.println("The five- and two-person boats were taken. 3 people can go, yet.");
        } else if (sum == 8) {
            System.out.println("The five- and three-person boats were taken. 2 people can go, yet.");
        } else if (sum <= 10) {
            System.out.println("All of the boats were taken. No one can boat anymore.");
        } else if (sum > 10) {
            System.out.println("All of the boats were taken. " + (sum - 10) + " people were left at the dock.");
        }

    }
}
