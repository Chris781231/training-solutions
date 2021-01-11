package week10.d01.senior;

public class Elevations {

    private double plusElevation;
    private double minusElevation;

    public double getPlusElevation() {
        return plusElevation;
    }

    public double getMinusElevation() {
        return minusElevation;
    }

    public void addPlusElevation(double elevation) {
        plusElevation += elevation;
    }

    public void addMinusElevation(double elevation) {
        minusElevation += elevation;
    }

    @Override
    public String toString() {
        return "Elevations{" +
                "plusElevation=" + plusElevation +
                ", minusElevation=" + minusElevation +
                '}';
    }
}
