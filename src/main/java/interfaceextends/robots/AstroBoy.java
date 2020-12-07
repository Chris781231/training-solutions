package interfaceextends.robots;

import java.util.ArrayList;
import java.util.List;

public class AstroBoy implements FlyableRobot {

    private Point position;
    private int angle;
    private final List<Point> path = new ArrayList<>();

    public static final long ALTITUDE = 5;

    public AstroBoy(Point position) {
        this.position = new Point(position.getX(), position.getY(), 0);
    }

    @Override
    public void liftTo(long altitude) {
        Point changedAltitude = new Point(position.getX(), position.getY(), altitude);
        position = changedAltitude;
        path.add(changedAltitude);
    }

    @Override
    public void moveTo(Point position) {
        Point target = new Point(position.getX(), position.getY(), getAltitude());
        this.position = target;
        path.add(target);
    }

    @Override
    public void fastMoveTo(Point position) {
        liftTo(ALTITUDE);
        moveTo(position);
        liftTo(0);
    }

    @Override
    public void rotate(int angle) {
        this.angle = angle;
    }

    @Override
    public List<Point> getPath() {
        return new ArrayList<>(path);
    }

    public Point getPosition() {
        return position;
    }

    public int getAngle() {
        return angle;
    }

    public long getAltitude() {
        return position.getZ();
    }
}
