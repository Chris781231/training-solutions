package week08.d03.midlevel;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringListsTest {

    StringLists stringLists = new StringLists();

    @Test
    void unionTest() {
        List<String> strings = List.of("1", "2", "3", "4", "5");
        List<String> anotherStrings = List.of("1", "3", "5", "7", "9");
        List<String> union = stringLists.stringListsUnion(strings, anotherStrings);
        assertEquals(7, union.size());
        assertEquals("2", union.get(1));
        assertEquals("9", union.get(union.size() - 1));
    }
}