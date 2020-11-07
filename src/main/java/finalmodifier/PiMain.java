package finalmodifier;

public class PiMain {

    public static void main(String[] args) {
        System.out.println(new CylinderCalculator().calculateVolume(5, 15));
        System.out.println(new CylinderCalculator().calculateSurfaceArea(5, 15));
        System.out.println(CircleCalculator.PI);
    }
}
