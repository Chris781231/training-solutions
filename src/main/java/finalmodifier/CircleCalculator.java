package finalmodifier;

public class CircleCalculator {

    public static final double PI = 3.14159265;

    public double calculatePerimeter(double r) {
        return 2 * r * PI;
    }

    public double calculateArea(double r) {
        return r * r * PI;
    }


    public static void main(String[] args) {

        System.out.println(new CircleCalculator().calculatePerimeter(5));
        System.out.println(new CircleCalculator().calculateArea(5));
    }
}
