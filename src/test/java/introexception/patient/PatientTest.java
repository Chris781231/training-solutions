package introexception.patient;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {

    @Test
    public void invalidSsn() {
        IllegalArgumentException iaException = assertThrows(IllegalArgumentException.class, () -> new Patient("John Doe", "abc", 2000));
        assertTrue(iaException.getMessage().contains("Invalid Social Security Number: "));
    }

    @Test
    public void validSsn() {
        Patient patient = new Patient("John Doe", "123456788", 2000);
        assertEquals("John Doe", patient.getName());
        assertEquals("123456788", patient.getSocialSecurityNumber());
        assertEquals(2000, patient.getYearOfBirth());
    }
}
