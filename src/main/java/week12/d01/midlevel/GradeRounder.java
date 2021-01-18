package week12.d01.midlevel;

public class GradeRounder {

    public static void main(String[] args) {
        GradeRounder gradeRounder = new GradeRounder();
        int[] grades = gradeRounder.roundGrades(new int[]{41, 42, 43, 44, 45, 46, 47, 48, 49, 50});
        for (int grade : grades) {
            System.out.println(grade);
        }
    }

    public int[] roundGrades(int[] grades) {
        for (int i = 0; i < grades.length; i++) {
            int grade = grades[i];
            int diffFromFiveMultiples = ((grade % 5 == 0) ? (0) : (5 - (grade % 5)));
            if (diffFromFiveMultiples != 0 &&
                    diffFromFiveMultiples < 3 &&
                    grade > 40) {
                grades[i] = grade + diffFromFiveMultiples;
            }
        }

        return grades;
    }
}
