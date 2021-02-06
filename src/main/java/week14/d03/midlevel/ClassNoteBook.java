package week14.d03.midlevel;

import java.util.*;

public class ClassNoteBook {

    private final List<Student> students = new ArrayList<>();

    public ClassNoteBook(Student... students) {
        this.students.addAll(Arrays.asList(students));
    }

    public static void main(String[] args) {
        ClassNoteBook noteBook = new ClassNoteBook(
                new Student("Jakab"),
                new Student("Dzsozi")
        );
        System.out.println(noteBook.sortNotebook());

        noteBook.students.get(0).addGrade(Subject.MATEMATIKA, 5);
        noteBook.students.get(0).addGrade(Subject.FIZIKA, 4);
        noteBook.students.get(0).addGrade(Subject.IRODALOM, 2);
        noteBook.students.get(1).addGrade(Subject.MATEMATIKA, 3);
        noteBook.students.get(1).addGrade(Subject.IRODALOM, 4);

        System.out.println(noteBook.sortNotebook());
    }

    public Set<Student> sortNotebook() {
        return new TreeSet<>(students);
    }

    public void addStudentByName(String name) {
        students.add(new Student(name));
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
}
