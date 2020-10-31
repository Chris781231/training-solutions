package localvariables;

public class DistanceMain {

    public static void main(String[] args) {

        Distance distance = new Distance(12.35, true);

        System.out.println("The distance in km: " + distance.getDistanceInKm());
        System.out.println("The distance is exact: " + distance.isExact());

        int notExactDistance = (int) distance.getDistanceInKm();
        System.out.println("The whole part of distance is " + notExactDistance);
    }

}
