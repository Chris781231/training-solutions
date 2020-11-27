package week05d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    @Test
    void userCreateTest() {
        User user = new User("Charlie", "Parker", "charlie.parker@gmail.com");
        assertEquals("Charlie Parker", user.getFullName());
        assertEquals("charlie.parker@gmail.com", user.getEmail());
    }

    @Test
    void firstNameLastNameEmailShouldThrowExceptionIfEmptyOrNull() {
        assertThrows(IllegalArgumentException.class, () -> new User("", "Parker", "email-address"));
        assertThrows(IllegalArgumentException.class, () -> new User(null, "Parker", "email-address"));
        assertThrows(IllegalArgumentException.class, () -> new User("Charlie", "", "email-address"));
        assertThrows(IllegalArgumentException.class, () -> new User("Charlie", null, "email-address"));
        assertThrows(IllegalArgumentException.class, () -> new User("Charlie", "Parker", ""));
        assertThrows(IllegalArgumentException.class, () -> new User("Charlie", "Parker", null));
    }

    @Test
    void emailShouldThrowExceptionIfNotContainAtSignOrDotCharacter() {
        assertThrows(IllegalArgumentException.class, () -> new User("Charlie", "Parker", "charlieparker@gmailcom"));
        assertThrows(IllegalArgumentException.class, () -> new User("Charlie", "Parker", "charlieparkergmail.com"));
        assertThrows(IllegalArgumentException.class, () -> new User("Charlie", "Parker", "charlieparkergmailcom"));
    }
}