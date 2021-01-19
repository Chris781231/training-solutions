package week11.d02.senior;

public class Ride {

    private final int dayOfWeek;
    private final int rideOfDay;
    private final int distanceInKm;

    public Ride(int dayOfWeek, int rideOfDay, int distanceInKm) {
        if (dayOfWeek < 1 || dayOfWeek > 7) {
            throw new IllegalArgumentException("the day of week must be between 1 and 7");
        }
        if (rideOfDay < 1) {
            throw new IllegalArgumentException("the ride number of day must be higher than 1");
        }
        if (distanceInKm <= 0) {
            throw new IllegalArgumentException("the distance must be higher than 1");
        }
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
