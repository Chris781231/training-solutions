package schoolrecords;

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
        if (o == null) {
            return false;
        }
        return o instanceof Subject && (((Subject) o).getSubjectName().equals(subjectName));
    }

}
