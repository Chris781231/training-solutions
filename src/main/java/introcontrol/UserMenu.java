package introcontrol;

import java.util.Scanner;

public class UserMenu {

    public static void main(String[] args) {

        System.out.println("MENU");
        System.out.println("1. List of users");
        System.out.println("2. Add user");
        System.out.println("Other: Exit");

        Scanner scanner = new Scanner(System.in);

        System.out.print("> ");
        String str = scanner.nextLine();

        if (str.equals("1")) {
            System.out.println("List of users...");
        } else if (str.equals("2")) {
            System.out.println("Add user...");
        }
    }
}
