package abstractclass.gamecharacter;

public class Point {

    private final long x;
    private final long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long distance(Point anotherPoint) {
        return (long) Math.sqrt(Math.pow((double) x - anotherPoint.x, 2) + Math.pow((double) y - anotherPoint.y, 2));
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }
}
