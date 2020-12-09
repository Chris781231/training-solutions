package virtualmethod.vehiclecaravan;

public class Vehicle {

    private final int vehicleWeight;

    public static final int PERSON_AVERAGE_WEIGHT = 75;

    public Vehicle(int vehicleWeight) {
        this.vehicleWeight = vehicleWeight;
    }

    public int getGrossLoad() {
        return vehicleWeight + PERSON_AVERAGE_WEIGHT;
    }

    public static int getPersonAverageWeight() {
        return PERSON_AVERAGE_WEIGHT;
    }

    public int getVehicleWeight() {
        return vehicleWeight;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleWeight=" + vehicleWeight +
                '}';
    }
}
