package week13.d03.midlevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AssignmentManager {

    private final List<Assignment> assignments = new ArrayList<>();

    public static void main(String[] args) {
        AssignmentManager am = new AssignmentManager();
        am.readFromFile(Assignment.class.getResourceAsStream("/beosztas.txt"));
        System.out.println(am.getWeeklyHoursByTeacher("Albatrosz Aladin"));
    }

    public void readFromFile(InputStream in) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            int counter = 0;
            String name = null;
            String subject = null;
            String className = null;
            int weeklyAmount = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                switch (counter) {
                    case 0 -> name = line;
                    case 1 -> subject = line;
                    case 2 -> className = line;
                    case 3 -> weeklyAmount = Integer.parseInt(line);
                    default -> throw new IllegalStateException("Unexpected value: " + counter);
                }
                if (counter == 3) {
                    assignments.add(new Assignment(name, subject, className, weeklyAmount));
                }
                counter = (counter == 3) ? 0 : counter + 1;
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("cannot read file", ioe);
        }
    }

    public int getWeeklyHoursByTeacher(String teacher) {
        int sum = 0;
        for (Assignment assignment : assignments) {
            if (assignment.getName().equals(teacher)) {
                sum += assignment.getWeeklyAmount();
            }
        }
        return sum;
    }

    public List<Assignment> getAssignments() {
        return new ArrayList<>(assignments);
    }
}
