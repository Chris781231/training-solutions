package week11.d02.midlevel;

import java.util.ArrayList;
import java.util.List;

public class Courier {

    private final List<Ride> rides = new ArrayList<>();

    public void addRide(int dayOfWeek, int rideOfDay, int distanceInKm) {
        if (!rides.isEmpty()) {
            checkRideParams(dayOfWeek, rideOfDay);
        }

        rides.add(new Ride(dayOfWeek, rideOfDay, distanceInKm));
    }

    private void checkRideParams(int dayOfWeek, int rideOfDay) {
        int lastDayOfRides = rides.get(rides.size() - 1).getDayOfWeek();
        int lastRideOfRides = rides.get(rides.size() - 1).getRideOfDay();

        if (dayOfWeek < lastDayOfRides) {
            throw new IllegalArgumentException("Wrong params");
        }
        if (dayOfWeek == lastDayOfRides && rideOfDay <= lastRideOfRides) {
            throw new IllegalArgumentException("Wrong params");
        }
    }

    public int findFirstDayOff() {
        if (rides.isEmpty()) {
            return 0;
        }
        int prevDay = rides.get(0).getDayOfWeek();

        for (Ride ride : rides) {
            if (ride.getDayOfWeek() - prevDay > 1) {
                return prevDay + 1;
            }
            prevDay = ride.getDayOfWeek();
        }

        return 0;
    }

    public List<Ride> getRides() {
        return new ArrayList<>(rides);
    }
}
