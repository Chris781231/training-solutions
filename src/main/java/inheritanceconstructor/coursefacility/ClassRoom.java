package inheritanceconstructor.coursefacility;

public class ClassRoom extends Room {

    private Facility facility;

    public ClassRoom(String location, int capacity, Facility facility) {
        super(location, capacity);
        this.facility = facility;
    }

    public boolean isSuitable(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course must not be null!");
        }
        return facility == course.getFacility() && getCapacity() > course.getParticipants();
    }

    public int getCapacity() {
        return super.getCapacity();
    }
}
