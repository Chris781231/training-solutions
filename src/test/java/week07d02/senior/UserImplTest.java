package week07d02.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserImplTest {

    @Test
    void userImplTest() {
        User user = User.of("CParker", "Charlie", "Parker");

        assertEquals("Charlie Parker", user.getFullName());
    }
}