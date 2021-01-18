package week11.d02.senior;

public class Ride {

    private final int dayOfWeek;
    private final int rideOfDay;
    private final int distanceInKm;

    public Ride(int dayOfWeek, int rideOfDay, int distanceInKm) {
        this.dayOfWeek = dayOfWeek;
        this.rideOfDay = rideOfDay;
        this.distanceInKm = distanceInKm;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int getRideOfDay() {
        return rideOfDay;
    }

    public int getDistanceInKm() {
        return distanceInKm;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "dayOfWeek=" + dayOfWeek +
                ", rideOfDay=" + rideOfDay +
                ", distanceInKm=" + distanceInKm +
                '}';
    }
}
