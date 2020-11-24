package methodchain.robot;

public class NavigationPoint {

    private final int actualDistance;
    private final int actualAzimuth;

    public NavigationPoint(int actualDistance, int actualAzimuth) {
        this.actualDistance = actualDistance;
        this.actualAzimuth = actualAzimuth;
    }

    @Override
    public String toString() { // distance: 5 azimut: 45
        return String.format("distance: %d azimut: %d", actualDistance, actualAzimuth);
    }
}
