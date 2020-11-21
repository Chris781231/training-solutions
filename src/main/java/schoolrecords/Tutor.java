package schoolrecords;

import java.util.List;

public class Tutor {

    private final String name;
    private final List<Subject> taughtSubjects;

    public Tutor(String name, List<Subject> taughtSubjects) {
        this.name = name;
        this.taughtSubjects = taughtSubjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getTaughtSubjects() {
        return taughtSubjects;
    }

    public boolean tutorTeachingSubject(Subject subject) {
        return taughtSubjects.contains(subject);
    }
}
