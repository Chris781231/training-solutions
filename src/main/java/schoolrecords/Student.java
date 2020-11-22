package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private final List<Mark> marks = new ArrayList<>();
    private final String name;

    public Student(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    public double calculateAverage() {
        double sum = 0;
        int count = 0;

        for (Mark mark : marks) {
            sum += mark.getMarkType().getValue();
            count++;
        }

        if (count != 0) {
            return Math.round((sum / count) * 100.0) / 100.0;
        }
        return 0.0;
    }

    public double calculateSubjectAverage(Subject subject) {
        double sum = 0;
        int count = 0;

        for (Mark mark : marks) {
            if (mark.getSubject().equals(subject)) {
                sum += mark.getMarkType().getValue();
                count++;
            }
        }

        if (count != 0) {
            return Math.round((sum / count) * 100.0) / 100.0;
        }
        return 0;
    }

    private boolean isEmpty(String name) {
        return name == null || name.isBlank();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Student && ((Student) o).getName().equals(name);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(name).append(" marks: ");
        for (Mark mark : marks) {
            output.append(mark.getSubject().getSubjectName()).append(": ").append(mark);
        }
        return output.toString();
    }
}
