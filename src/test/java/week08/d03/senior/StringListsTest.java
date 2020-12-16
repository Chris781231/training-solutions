package week08.d03.senior;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class StringListsTest {

    StringLists stringLists = new StringLists();
    List<String> strings = List.of("aaa", "bb", "cc", "ddd", "eeee");

    @Test
    void getShortestWordsTest() {
        List<String> expected = List.of("bb", "cc");
        assertArrayEquals(expected.toArray(), stringLists.getShortestWords(strings).toArray());
    }


}