package methodchain.robot;

import java.util.ArrayList;
import java.util.List;

public class Robot {

    private int distance = 0;
    private int azimuth = 0;
    private final List<NavigationPoint> navigationPoints= new ArrayList<>();

    public int getDistance() {
        return distance;
    }

    public int getAzimut() {
        return azimuth;
    }

    public Robot go(int meter) {
        distance += meter;
        return this;
    }

    public Robot rotate(int angle) {
        azimuth += angle;
        return this;
    }

    public Robot registerNavigationPoint() {
        navigationPoints.add(new NavigationPoint(distance, azimuth));
        return this;
    }

    public List<NavigationPoint> getNavigationList() {
        return navigationPoints;
    }
}
