package week14.d03.midlevel;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Student implements Comparable<Student> {

    private final String name;
    private final Map<Subject, List<Integer>> grades = new EnumMap<>(Subject.class);

    public Student(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Student student = new Student("Jakab");
        student.addGrade(Subject.MATEMATIKA, 5);
        student.addGrade(Subject.IRODALOM, 2);
        student.addGrade(Subject.MATEMATIKA, 4);
        System.out.println(student.getGrades());
    }

    public void addGrade(Subject subject, int grade) {
        List<Integer> gradeOfSubject;
        if (!grades.containsKey(subject)) {
            gradeOfSubject = new ArrayList<>();
        } else {
            gradeOfSubject = grades.get(subject);
        }
        gradeOfSubject.add(grade);
        grades.put(subject,gradeOfSubject);

    }

    public String getName() {
        return name;
    }

    public Map<Subject, List<Integer>> getGrades() {
        return new EnumMap<>(grades);
    }

    @Override
    public String toString() {
        return name + " " + grades;
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name);
    }
}
