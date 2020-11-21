package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private final String className;
    private final Random rnd;
    private final List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        if (isEmpty(className)) {
            throw new IllegalArgumentException("Class name must not be empty!");
        }
        this.className = className;
        this.rnd = rnd;
    }

    public String getClassName() {
        return className;
    }

    public boolean addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            return true;
        }
        return false;
    }

    public boolean removeStudent(Student student) {
        return students.remove(student);
    }

    public double calculateClassAverage() {
        if (students.isEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }

        double sum = 0;
        int count = 0;
        boolean studentsMarkIsEmpty = true;

        for (Student student : students) {
            if (student.calculateAverage() != 0.0) {
                studentsMarkIsEmpty = false;
                sum += student.calculateAverage();
                count++;
            }
        }

        if (studentsMarkIsEmpty) {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }

        return Math.round((sum / count) * 100) / 100.0;
    }

    public double calculateClassAverageBySubject(Subject subject) {
        if (students.isEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }

        double sum = 0;
        int count = 0;
        boolean studentsMarkIsEmpty = true;

        for (Student student : students) {
            if (student.calculateSubjectAverage(subject) != 0.0) {
                studentsMarkIsEmpty = false;
                sum += student.calculateSubjectAverage(subject);
                count++;
            }
        }

        if (studentsMarkIsEmpty) {
            throw new IllegalStateException("No marks present, average calculation aborted!");
        }

        return Math.round((sum / count) * 100) / 100.0;
    }

    public Student findStudentByName(String studentToFind) {
        if (studentToFind.isBlank()) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        if (students.isEmpty()) {
            throw new IllegalStateException("No students to search!");
        }
        for (Student student : students) {
            if (student.getName().equals(studentToFind)) {
                return student;
            }
        }
        throw new IllegalArgumentException("Student by this name cannot be found! Kiss Rita");
    }

    public Student repetition() {
        if (students.isEmpty()) {
            throw new IllegalStateException("No students to select for repetition!");
        }
        return students.get(rnd.nextInt(students.size()));
    }

    public String listStudentNames() {
        if (students.isEmpty()) {
            throw new IllegalStateException("No students in the class! Listing aborted!");
        }

        StringBuilder studentNames = new StringBuilder();
        for (Student student : students) {
            if (studentNames.isEmpty()) {
                studentNames.append(student.getName());
            } else {
                studentNames.append(", ").append(student.getName());
            }
        }
        return studentNames.toString();
    }

    public List<StudyResultByName> listStudyResults() {
        if (students.isEmpty()){
            throw new IllegalStateException("No students in the class! Listing aborted!");
        }

        List<StudyResultByName> studyResultByNames = new ArrayList<>();
        for (Student student : students) {
            double average = student.calculateAverage();
            String name = student.getName();
            studyResultByNames.add(new StudyResultByName(average, name));
        }

        return studyResultByNames;
    }

    private boolean isEmpty(String name) {
        return name == null || name.isBlank();
    }
}
