package schoolrecords;

public class StudyResultByName {

    private final String studentName;
    private final double studyAverage;

    public StudyResultByName(double studyAverage, String studentName) {
        this.studyAverage = studyAverage;
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getStudyAverage() {
        return studyAverage;
    }
}
