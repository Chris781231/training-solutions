package math.game;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distance(Point other) {
        int distanceX = Math.abs(getX() - other.getX());
        int distanceY = Math.abs(getY() - other.getY());
        return Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
    }


    public static void main(String[] args) {
        Point a = new Point(3, 4);
        Point b = new Point(0, 0);
        System.out.println(a.distance(b));

    }
}
