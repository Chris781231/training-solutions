package inheritanceconstructor.carjeep;

public class Car {

    private final double fuelRate;
    private double fuel;
    private final double tankCapacity;

    public Car(double fuelRate, double fuel, double tankCapacity) {
        if (fuel > tankCapacity) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.fuelRate = fuelRate;
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }

    public void modifyFuelAmount(double fuel) {
        double refuelableAmount = calculateRefillAmount();
        if (fuel > refuelableAmount) {
            throw new IllegalArgumentException(String.format("The tank can be filled with up to %,.2f of fuel", refuelableAmount));
        }
        this.fuel += fuel;
    }

    public void drive(int km) {
        if (isDriveableKm(km)) {
            double consumedFuel = km * fuelRate / 100;
            this.fuel -= consumedFuel;
        }
    }

    public double calculateRefillAmount() {
        return tankCapacity - fuel;
    }

    public double getFuel() {
        return fuel;
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    private boolean isDriveableKm(int km) {
        double driveableKm = fuel / fuelRate * 100;
        if (km > driveableKm) {
            throw new IllegalArgumentException("Not enough fuel available!");
        }
        return true;
    }
}
