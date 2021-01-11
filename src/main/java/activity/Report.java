package activity;

public class Report {

    private final ActivityType activityType;
    private final double distance;

    public Report(ActivityType activityType, double distance) {
        this.activityType = activityType;
        this.distance = distance;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Report{" +
                "activityType=" + activityType +
                ", distance=" + distance +
                '}';
    }
}
