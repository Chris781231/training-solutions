package numbers;

import java.util.Scanner;

public class CircleMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me two circle's diameter as an integer...");
        System.out.print("First diameter: ");
        int diameter = Integer.parseInt(scanner.nextLine());
        System.out.print("Second diameter: ");
        int diameter2 = Integer.parseInt(scanner.nextLine());

        Circle circle = new Circle(diameter);
        Circle circle2 = new Circle(diameter2);
        System.out.printf("Diameter: %d, Perimeter: %f, Area: %f%n",circle.getDiameter(), circle.perimeter(), circle.area());
        System.out.printf("Diameter: %d, Perimeter: %f, Area: %f%n",circle2.getDiameter(), circle2.perimeter(), circle2.area());
    }
}
