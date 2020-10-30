package classstructureattributes;

import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) {

        Client client = new Client();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Client Class App\n");

        System.out.println("What's your name?");
        client.name = scanner.nextLine();

        System.out.println("What's your year of birth?");
        client.year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("What's your address?");
        client.address = scanner.nextLine();

        System.out.println("Check:");
        System.out.println("Your name is " + client.name);
        System.out.println("Your year of birth is " + client.year);
        System.out.println("Your address is " + client.address);

    }

}
