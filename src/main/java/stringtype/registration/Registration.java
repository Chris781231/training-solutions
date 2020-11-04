package stringtype.registration;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {

        // Request username, password, email
        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password (min 8 characters): ");
        String password1 = scanner.nextLine();

        System.out.print("Password again: ");
        String password2 = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        // Verification
        UserValidator uv = new UserValidator();

        boolean validUsername = uv.isValidUsername(username);
        boolean validPassword = uv.isValidPassword(password1, password2);
        boolean validEmail = uv.isValidEmail(email);

        System.out.println(validUsername ? "Username is valid" : "Invalid username");
        System.out.println(validPassword ? "Password is valid" : "Invalid password");
        System.out.println(validEmail ? "Email is valid" : "Invalid email");
    }
}
