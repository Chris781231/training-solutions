package iofilestest.cheese;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class CheeseManagerTest {

    @TempDir
    File tempFolder;
    Path path = new File(tempFolder + "cheese.txt").toPath();

    @Test
    void writeToFileTest() throws IOException, EOFException {
        CheeseManager manager = new CheeseManager();
        List<Cheese> cheeses = List.of(
                new Cheese("Feta sajt", 0.5),
                new Cheese("Cheddar", 0.45),
                new Cheese("Camembert", 0.08)
        );
        manager.saveToFile(path, cheeses);

        DataInputStream dis = new DataInputStream(new BufferedInputStream(Files.newInputStream(path)));


    }
}