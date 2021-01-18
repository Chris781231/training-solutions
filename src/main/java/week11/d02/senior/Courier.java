package week11.d02.senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Courier implements Comparator<Ride> {

    private final List<Ride> rides = new ArrayList<>();

    public static void main(String[] args) {
        Courier courier = new Courier();
        courier.readRidesFromFile(Courier.class.getResourceAsStream("rides.csv"));
        System.out.println(courier.findFirstRideOfWeek());
        System.out.println(courier.findDayOffs());
        int[] distancePerDay = courier.getDistancePerDay();
        for (int temp : distancePerDay) {
            System.out.println(temp);
        }
    }

    public void readRidesFromFile(InputStream in) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while((line = reader.readLine()) != null) {
                processLine(line);
            }
            sort(rides);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private void processLine(String line) {
        String[] parts = line.split(";");
        rides.add(new Ride(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
    }

    private void sort(List<Ride> rides) {
        for (int i = 0; i < rides.size() - 1; i++) {
            for (int j = 0; j < rides.size() - i - 1; j++) {
                if (compare(rides.get(j), rides.get(j + 1)) > 0) {
                    Ride temp = rides.get(j);
                    rides.set(j, rides.get(j + 1));
                    rides.set(j + 1, temp);
                }
            }
        }
    }

    public Ride findFirstRideOfWeek() {
        checkRides();
        return rides.get(0);
    }

    public List<Integer> findDayOffs() {
        checkRides();
        List<Integer> dayOffs = new ArrayList<>();
        boolean[] workDays = new boolean[7];
        for (Ride ride : rides) {
            workDays[ride.getDayOfWeek() - 1] = true;
        }
        for (int i = 0; i < workDays.length; i++) {
            if (!workDays[i]) {
                dayOffs.add(i + 1);
            }
        }
        return dayOffs;
    }

    public int[] getDistancePerDay() {
        checkRides();
        int[] distancePerDay = new int[7];
        for (Ride ride : rides) {
            distancePerDay[ride.getDayOfWeek() - 1] += ride.getDistanceInKm();
        }
        return distancePerDay;
    }

    private void checkRides() {
        if (rides.isEmpty()) {
            throw new IllegalArgumentException("The Rides is empty!");
        }
    }

    public List<Ride> getRides() {
        return new ArrayList<>(rides);
    }

    @Override
    public int compare(Ride o1, Ride o2) {
        if (o1.getDayOfWeek() < o2.getDayOfWeek()) {
            return -1;
        }
        if ((o1.getDayOfWeek() == o2.getDayOfWeek()) &&
                (o1.getRideOfDay() < o2.getRideOfDay())) {
            return -1;
        }
        if ((o1.getDayOfWeek() == o2.getDayOfWeek()) &&
                (o1.getRideOfDay() == o2.getRideOfDay())) {
            return 0;
        }
        if ((o1.getDayOfWeek() == o2.getDayOfWeek()) &&
                (o1.getRideOfDay() > o2.getRideOfDay())) {
            return 1;
        }
        if (o1.getDayOfWeek() > o2.getDayOfWeek()) {
            return 1;
        }
        return 0;
    }
}
