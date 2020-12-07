package interfaceextends.robots;

import java.util.ArrayList;
import java.util.List;

public class C3PO implements MoveableRobot {

    private Point position;
    private int angle;
    private final List<Point> path = new ArrayList<>();

    public C3PO(Point position) {
        this.position = new Point(position.getX(), position.getY(), 0);
    }

    @Override
    public void moveTo(Point position) {
        fastMoveTo(new Point(position.getX(), position.getY(), 0));
    }

    @Override
    public void fastMoveTo(Point position) {
        this.position = position;
        path.add(position);
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
}
