package week09.d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person youngPerson = new Person("Szabina", 19);
    Person child = new Person("Luca", 2);

    @Test
    void setPresent() {
        assertNull(youngPerson.getPresent());
        assertNull(child.getPresent());
        for (int i = 0; i < 1000; i++) {
            youngPerson.setPresent();
            child.setPresent();
            assertNotNull(youngPerson.getPresent());
            assertNotEquals(Present.TOY, youngPerson.getPresent());
            assertNotNull(child.getPresent());
        }
    }
}