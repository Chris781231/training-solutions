package inheritanceconstructor.coursefacility;

public class Course {

    private int participants;
    private Facility facilityNeeded;

    public Course(int participants, Facility facility) {
        this.participants = participants;
        this.facilityNeeded = facility;
    }

    public int getParticipants() {
        return participants;
    }

    public Facility getFacilityNeeded() {
        return facilityNeeded;
    }
}
