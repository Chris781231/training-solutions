package week07d04.senior;

import java.util.Scanner;

public class ShoppingList {

    /**
     * @param path The path to the file to be scanned
     * @return Sum of amount multiply by unit price from scanned file
     */
    public long calculateSum(String path) {
        long sum = 0;

        try (Scanner fileScanner = new Scanner(ShoppingList.class.getResourceAsStream(path + "shopping_list.csv"))) {
            while (fileScanner.hasNextLine()) {
                sum = getSum(sum, fileScanner);
            }
        } catch (NullPointerException npi) {
            System.out.println("Invalid path!");
        }

        return sum;
    }

    private long getSum(long sum, Scanner fileScanner) {
        String row = fileScanner.nextLine();
        String[] rowItem = row.split(";");

        int amount = Integer.parseInt(rowItem[1]);
        int unitPrice = Integer.parseInt(rowItem[2]);

        sum += amount * unitPrice;
        return sum;
    }
}
