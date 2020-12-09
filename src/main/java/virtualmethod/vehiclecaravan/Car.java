package virtualmethod.vehiclecaravan;

public class Car extends Vehicle {

    private final int numberPassenger;

    public Car(int vehicleWeight, int numberPassenger) {
        super(vehicleWeight);
        this.numberPassenger = numberPassenger;
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() + numberPassenger * getPersonAverageWeight();
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfPassenger=" + numberPassenger +
                ", vehicleWeight=" + getVehicleWeight() +
                '}';
    }

    public int getNumberPassenger() {
        return numberPassenger;
    }
}
