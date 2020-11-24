package immutable.spaceagency;

public class Satellite {

    private final String registerIdent;
    private CelestialCoordinates celestialCoordinates;

    public Satellite(CelestialCoordinates destinationCoordinates, String registerIdent) {
        if (isEmpty(registerIdent)) {
            throw new IllegalArgumentException("Register ident must not be empty!");
        }

        celestialCoordinates = destinationCoordinates;
        this.registerIdent = registerIdent;
    }

    public void modifyDestination(CelestialCoordinates diff) {
        int xCoordinate = celestialCoordinates.getXCoordinate() + diff.getXCoordinate();
        int yCoordinate = celestialCoordinates.getYCoordinate() + diff.getYCoordinate();
        int zCoordinate = celestialCoordinates.getZCoordinate() + diff.getZCoordinate();

        celestialCoordinates = new CelestialCoordinates(xCoordinate, yCoordinate, zCoordinate);
    }

    public String getRegisterIdent() {
        return registerIdent;
    }

    private boolean isEmpty(String str) {
        if (str == null || str.isBlank()) {
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("%s: %s", registerIdent, celestialCoordinates);
    }
}
