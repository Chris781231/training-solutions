package ioreader.grades;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private final String name;
    private final List<Integer> gradeList;

    public Student(String name, List<Integer> gradeList) {
        checkParams(name, gradeList);
        this.name = name;
        this.gradeList = gradeList;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGradeList() {
        return new ArrayList<>(gradeList);
    }

    private void checkParams(String name, List<Integer> gradeList) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is null or empty");
        }
        if (gradeList == null) {
            throw new IllegalArgumentException("grades is null");
        }
    }

    public double average() {
        if (gradeList.isEmpty()) {
            return 0;
        }

        double sum = 0;

        for (int grade : gradeList) {
            sum += grade;
        }

        return sum / gradeList.size();
    }

    public boolean isIncreasing() {
        for (int i = 0; i < gradeList.size() - 1; i++) {
            if (gradeList.get(i) > gradeList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
