package week07d04.midlevel;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LabTest {
    Lab lab = new Lab("Learn");
    Lab anotherLab = new Lab("Learn", LocalDateTime.of(2020, 12, 31, 23, 59));

    @Test
    void createLabTest() {
        assertEquals("Lab{title='Learn', completed=false, completedAt=null}", lab.toString());
        assertEquals("Lab{title='Learn', completed=true, completedAt=2020-12-31T23:59}", anotherLab.toString());
    }

    @Test
    void uncompletedLabTest() {
        assertFalse(lab.isCompleted());
        lab.complete();
        assertTrue(lab.isCompleted());
    }

    @Test
    void completedLabTest() {
        assertTrue(anotherLab.isCompleted());
        Exception ex = assertThrows(IllegalArgumentException.class, () -> anotherLab.complete());
        assertEquals("This lab is already completed at 2020-12-31T23:59!", ex.getMessage());
    }
}