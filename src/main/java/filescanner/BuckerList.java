package filescanner;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class BuckerList {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(Path.of("bucketlist.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException ioe) {
            System.out.println("File reading error: '" + ioe.getMessage() + "'");
        }
    }
}
