package week09.d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SantaClausTest {

    SantaClaus santaClaus = new SantaClaus(List.of(
            new Person("Karcsi", 42),
            new Person("Regina", 23),
            new Person("Szabina", 19),
            new Person("Máté", 17),
            new Person("Luca", 2)
    ));

    @Test
    void getThroughChimneys() {
        santaClaus.getThroughChimneys();
        for (Person person : santaClaus.getPersons()) {
            assertNotNull(person.getPresent());
        }
    }
}