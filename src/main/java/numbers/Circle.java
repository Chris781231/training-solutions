package numbers;

public class Circle {

    private static final double PI = 3.14F;

    private int diameter;

    public Circle(int diameter) {
        this.diameter = diameter;
    }

    public static double getPI() {
        return PI;
    }

    public int getDiameter() {
        return diameter;
    }

    public double perimeter() {
        return getDiameter() * PI;
    }

    public double area() {
        return Math.pow(getDiameter() / 2.0, 2) * PI;
    }
}
