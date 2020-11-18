package week04.modul2_projectwork;

public class Mark {

    private final MarkType markType;
    private final Subject subject;
    private final Tutor tutor;

    public Mark(MarkType markType, Subject subject, Tutor tutor) {
        this.markType = markType;
        if (subject == null || tutor == null) {
            throw new NullPointerException("Both subject and tutor must be provided!");
        }
        this.subject = subject;
        this.tutor = tutor;
    }

    public Mark(String markType, Subject subject, Tutor tutor) {
        boolean found = false;
        for (MarkType mark : MarkType.values()) {
            if (mark.name().equals(markType)) {
                found = true;
                break;
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Invalid mark type: " + markType);
        }

        this.markType = MarkType.valueOf(markType);
        if (subject == null || tutor == null) {
            throw new NullPointerException("Both subject and tutor must be provided!");
        }
        this.subject = subject;
        this.tutor = tutor;
    }

    public MarkType getMarkType() {
        return markType;
    }

    public Subject getSubject() {
        return subject;
    }

    public Tutor getTutor() {
        return tutor;
    }

    @Override
    public String toString() {
        return "%s(%d)".formatted(markType.getDescription(), markType.getValue());
    }
}
