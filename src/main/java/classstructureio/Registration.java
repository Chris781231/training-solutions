package classstructureio;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Registration App\n");
        System.out.println("What's your name?");
        String name = scanner.nextLine();
        System.out.println("What's your email-address?");
        String email = scanner.nextLine();

        System.out.println("Your registrated name: " + name);
        System.out.println("and email: " + email);

    }

}
