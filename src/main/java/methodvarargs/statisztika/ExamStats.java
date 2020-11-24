package methodvarargs.statisztika;

public class ExamStats {

    private final double maxPoints;

    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results) {
        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }

        double limit = maxPoints * limitInPercent / 100;
        int numberOfTopGrades = 0;

        for (int result : results) {
            if (result >= limit) {
                numberOfTopGrades++;
            }
        }

        return numberOfTopGrades;
    }

    public boolean hasAnyFailed(int limitInPercent, int... results) {
        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }

        double limit = maxPoints * limitInPercent / 100;

        for (int result : results) {
            if (result < limit) {
                return true;
            }
        }

        return false;
    }
}
