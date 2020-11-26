package methodpass;

public class Position {

    private final double posX;
    private final double posY;

    public Position(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double distanceFrom(Position position) {
        return Math.sqrt(Math.pow(this.posX - position.posX, 2) + Math.pow(this.posY - position.posY, 2));
    }
}
