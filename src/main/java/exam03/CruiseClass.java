package exam03;

public enum CruiseClass {

    LUXURY(3.0),
    FIRST(1.8),
    SECOND(1.0);

    private final double priceMultiplier;

    CruiseClass(double priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }
}
