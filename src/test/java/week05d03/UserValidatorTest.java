package week05d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    @Test
    void userValidatorOkayTest() {
        assertTrue(new UserValidator().validate(List.of(new User("Nagy Jakab", 35), new User("Kis Pisti", 18))));
    }

    @Test
    void userValidatorShouldThrowIllegalArgumentExceptionIfListEmptyOrNull() {
        assertThrows(IllegalArgumentException.class, () -> new UserValidator().validate(null));
        assertThrows(IllegalArgumentException.class, () -> new UserValidator().validate(List.of()));
    }

    @Test
    void userValidatorShouldThrowIllegalArgumentExceptionIfNameOfUserIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new UserValidator().validate(List.of(new User("\n\t", 35))));
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new UserValidator().validate(List.of(new User(null, 35))));
        assertEquals("Name must not be empty!", ex.getMessage());
    }

    @Test
    void userValidatorShouldThrowIllegalArgumentExcpetionIfAgeIsNegativeOrGreaterThan120() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new UserValidator().validate(List.of(new User("Matuzsálem néni", 125))));
        assertEquals("Age must be between 0 and 120!", ex.getMessage());
    }
}