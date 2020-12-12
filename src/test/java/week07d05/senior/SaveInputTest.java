package week07d05.senior;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaveInputTest {

    @Test
    void fileWriteTest() {
        FileReader fr = new FileReader("test.txt");
        List<String> linesFromFile = fr.getLinesFromFile();

        assertEquals(3, linesFromFile.size());
        assertEquals("2", linesFromFile.get(1));
    }
}