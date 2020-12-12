package week07d05.senior;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveInput {

    private final Scanner scanner = new Scanner(System.in);
    private final List<String> scannedLines = new ArrayList<>();

    public void run() {
        scanLines();
        writeToFile();
    }

    private void scanLines() {
        System.out.println("Három sor szöveget fogok kérni! Az egyes sorok végén nyomj [Enter]-t!");
        for (int i = 0; i < 3; i++) {
            scannedLines.add(scanner.nextLine());
        }

    }

    private void writeToFile() {
        System.out.println("Kérem a file nevét, ahol tárolni szeretnéd:");
        Path file = Path.of(scanner.nextLine());

        try {
            Files.write(file, scannedLines);
        } catch (IOException e) {
            System.out.println("Az elérési út nem létezik!");
        }
    }

    public static void main(String[] args) {
        SaveInput saveInput = new SaveInput();
        saveInput.run();
    }
}
