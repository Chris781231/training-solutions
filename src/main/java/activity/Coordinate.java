package activity;

public class Coordinate {

    public static final int MIN_LATITUDE = -90;
    public static final int MAX_LATITUDE = 90;
    public static final int MIN_LONGITUDE = -180;
    public static final int MAX_LONGITUDE = 180;
    private final double latitude;
    private final double longitude;

    public Coordinate(double latitude, double longitude) {
        if (latitude < MIN_LATITUDE || latitude > MAX_LATITUDE ||
                longitude < MIN_LONGITUDE || longitude > MAX_LONGITUDE) {
            throw new IllegalArgumentException();
        }
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
