package week14.d03.midlevel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {

    ClassNoteBook noteBook = new ClassNoteBook(
            new Student("Jakab"),
            new Student("Dzsozi")
    );

    @BeforeEach
    void setUp() {
        noteBook.getStudents().get(0).addGrade(Subject.MATEMATIKA, 5);
        noteBook.getStudents().get(0).addGrade(Subject.FIZIKA, 4);
        noteBook.getStudents().get(0).addGrade(Subject.IRODALOM, 2);
        noteBook.getStudents().get(1).addGrade(Subject.MATEMATIKA, 3);
        noteBook.getStudents().get(1).addGrade(Subject.IRODALOM, 4);
    }

    @Test
    void sortNotebook() {
        assertEquals("[Dzsozi {MATEMATIKA=[3], IRODALOM=[4]}, Jakab {MATEMATIKA=[5], IRODALOM=[2], FIZIKA=[4]}]",
                noteBook.sortNotebook().toString());
    }

    @Test
    void addStudentByName() {
        noteBook.addStudentByName("Lujza");
        assertEquals(3, noteBook.getStudents().size());
        assertEquals("Lujza", noteBook.getStudents().get(2).getName());
    }
}