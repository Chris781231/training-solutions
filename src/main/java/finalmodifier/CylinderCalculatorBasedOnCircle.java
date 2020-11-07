package finalmodifier;

public class CylinderCalculatorBasedOnCircle {

    public double calculateVolume(double r, double h) {
        return new CircleCalculator().calculateArea(r) * h;
    }

    public double calculateSurfaceArea(double r, double h) {
        return new CircleCalculator().calculatePerimeter(r) * h + 2 * new CircleCalculator().calculateArea(r);
    }


    public static void main(String[] args) {
        System.out.println(new CylinderCalculatorBasedOnCircle().calculateVolume(5, 15));
        System.out.println(new CylinderCalculatorBasedOnCircle().calculateSurfaceArea(5, 15));
    }
}
