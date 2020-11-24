package methodstructure.bodymass;

public class BodyMass {

    private double weight;
    private double height;

    public BodyMass(double mass, double height) {
        weight = mass;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double bodyMassIndex() {
        return weight / Math.pow(height, 2);
    }

    public BmiCategory body() {
        if (bodyMassIndex() < 18.5) {
            return BmiCategory.UNDERWEIGHT;
        }
        if (bodyMassIndex() > 25) {
            return BmiCategory.OVERWEIGHT;
        }
        return BmiCategory.NORMAL;
    }

    public boolean isThinnerThan(BodyMass bodyMass) {
        return bodyMassIndex() < bodyMass.bodyMassIndex();
    }
}
