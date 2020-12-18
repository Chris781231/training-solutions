package ioreader.grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {

    private final List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void readGradesFromFile(String path) {
        Path file = Path.of(path);
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String row;
            while ((row = reader.readLine()) != null) {
                String[] rowItems = row.split(" ");
                String name = rowItems[0];
                List<Integer> grades = new ArrayList<>();
                for (int i = 1; i < rowItems.length; i++) {
                    grades.add(Integer.parseInt(rowItems[i]));
                }
                students.add(new Student(name, grades));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid path or filename", e);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Invalid grade in file", e);
        }
    }

    public double classAverage() {
        if (students.isEmpty()) {
            return 0;
        }

        double sum = 0;
        int count = 0;

        for (Student student : students) {
            if (!student.getGradeList().isEmpty()) {
                sum += student.average();
                count++;
            }
        }

        return count != 0 ? sum / count : 0;
    }
}
