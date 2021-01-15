package iofilestest.cheese;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CheeseManager {

    public void saveToFile(Path path, List<Cheese> cheeses) {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            for (Cheese cheese : cheeses) {
                dos.writeUTF(cheese.getName());
                dos.writeDouble(cheese.getLactose());
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot reach file", ioe);
        }
    }

    public Cheese findCheese(Path path, String cheeseName) {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(Files.newInputStream(path)))) {

            do {
                String name = dis.readUTF();
                System.out.println(name);
                double lactose = dis.readDouble();
                System.out.println(lactose);
                if (name.equals(cheeseName)) {
                    return new Cheese(name, lactose);
                }
            } while (true);
        } catch (EOFException eofe) {
            return null;
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
    }

    public static void main(String[] args) {
        CheeseManager manager = new CheeseManager();
        Path path = Path.of("cheeses.txt");

        manager.saveToFile(path, List.of(
                new Cheese("Feta sajt", 0.5),
                new Cheese("Cheddar", 0.45),
                new Cheese("Camembert", 0.08)
        ));

        System.out.println(manager.findCheese(path, "Cheddar"));
    }
}
