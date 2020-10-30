package classstructureintegrate;

import java.util.Scanner;

public class ProductMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What's the your product?");
        String name = scanner.nextLine();
        System.out.println("What is the price of the product?");
        int price = scanner.nextInt();

        Product product = new Product(name, price);
        product.increasePrice(15);
        System.out.println("The product's new price is: " + product.getPrice());
        product.decreasePrice(25);
        System.out.println("The product's new price is " + product.getPrice());

    }

}
