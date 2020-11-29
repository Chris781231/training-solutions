package inheritanceconstructor.carjeep;

public class Jeep  extends Car {

    private final double extraCapacity;
    private double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        if (extraFuel > extraCapacity) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    @Override
    public void modifyFuelAmount(double fuel) {
        double refillableAmount = calculateRefillAmount();
        if (fuel > refillableAmount) {
            throw new IllegalArgumentException(String.format("The tank can be filled with up to %,.2f of fuel", refillableAmount));
        }
        if (fuel < getTankCapacity()) {
            super.modifyFuelAmount(fuel);
        } else {
            double refillTankAmount = fuel - super.calculateRefillAmount();
            super.modifyFuelAmount(refillTankAmount);
            extraFuel += fuel - refillTankAmount;
        }
    }

    @Override
    public void drive(int km) {
        if (isDriveableKm(km)) {
            double consumedFuel = km * getFuelRate() / 100;
            if (extraFuel > 0 && extraFuel >= consumedFuel) {
                extraFuel -= consumedFuel;
            } else if (extraFuel > 0) {
                super.modifyFuelAmount(-(consumedFuel - extraFuel));
                extraFuel = 0;
            }
        }
    }

    @Override
    public double calculateRefillAmount() {
        return (getTankCapacity() + extraCapacity) - (getFuel() + extraFuel);
    }

    public double getExtraFuel() {
        return extraFuel;
    }

    private boolean isDriveableKm(int km) {
        double driveableKm = (getFuel() + extraFuel) / getFuelRate() * 100;
        if (km > driveableKm) {
            throw new IllegalArgumentException("Not enough fuel available!");
        }
        return true;
    }
}
