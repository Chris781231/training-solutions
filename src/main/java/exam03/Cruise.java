package exam03;

import java.time.LocalDate;
import java.util.*;

public class Cruise {

    private final Boat boat;
    private final LocalDate sailing;
    private final double basicPrice;
    private final List<Passenger> passengers = new ArrayList<>();

    public static final int BASE_PRICE = 100_000;

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public void bookPassenger(Passenger passenger) {
        if (passengers.size() >= boat.getMaxPassengers()) {
            throw new IllegalArgumentException("Sorry, the boat is full");
        }
        passengers.add(passenger);
    }

    public double getPriceForPassenger(Passenger passenger) {
        return BASE_PRICE * passenger.getCruiseClass().getPriceMultiplier();
    }

    public Passenger findPassengerByName(String name) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equals(name)) {
                return passenger;
            }
        }

        return null;
    }

    public List<String> getPassengerNamesOrdered() {
        List<String> result = new ArrayList<>();

        for (Passenger passenger : passengers) {
            result.add(passenger.getName());
        }

        Collections.sort(result);
        return result;
    }

    public double sumAllBookingsCharged() {
        double sum = 0;

        for (Passenger passenger : passengers) {
            sum += getPriceForPassenger(passenger);
        }

        return sum;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> countOfPassengers = new HashMap<>();

        for (Passenger passenger : passengers) {
            CruiseClass classOfPassenger = passenger.getCruiseClass();
            if (countOfPassengers.containsKey(classOfPassenger)) {
                countOfPassengers.put(classOfPassenger, countOfPassengers.get(classOfPassenger) + 1);
            } else {
                countOfPassengers.put(classOfPassenger, 1);
            }
        }

        return countOfPassengers;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(passengers);
    }
}
