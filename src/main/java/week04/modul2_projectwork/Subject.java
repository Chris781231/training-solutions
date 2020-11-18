package week04.modul2_projectwork;

public class Subject {

    private final String subjectName;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Subject && (((Subject) o).getSubjectName().equals(subjectName));
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
