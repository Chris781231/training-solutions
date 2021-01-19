package week11.d04.senior;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NameLengthTest {

    @Test
    void getLengths() {
        NameLength nameLength = new NameLength();
        List<String> names = List.of("Joe", "Jack", "Jane", "Jake", "George", "William");
        Set<Integer> result = new HashSet<>();
        result.add(3);
        result.add(4);
        System.out.println(nameLength.getLengths(names));
        assertEquals(result, nameLength.getLengths(names));
    }
}