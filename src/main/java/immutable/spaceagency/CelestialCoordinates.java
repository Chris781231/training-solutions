package immutable.spaceagency;

public class CelestialCoordinates {

    private final int xCoordinate;
    private final int yCoordinate;
    private final int zCoordinate;

    public CelestialCoordinates(int xCoordinate, int yCoordinate, int zCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public int getZCoordinate() {
        return zCoordinate;
    }

    @Override
    public String toString() {
        return String.format("CelestialCoordinates: x=%d, y=%d, z=%d", xCoordinate, yCoordinate, zCoordinate);
    }
}
