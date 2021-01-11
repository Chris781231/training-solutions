package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {

    private final List<Activity> activityList;

    public Activities(List<Activity> activityList) {
        this.activityList = activityList;
    }

    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public List<Report> distancesByTypes() {
        double[] distances = calcDistancesByTypes();
        List<Report> reports = new ArrayList<>();
        for (int i = 0; i < ActivityType.values().length; i++) {
            reports.add(new Report(ActivityType.values()[i], distances[i]));
        }
        return reports;
    }

    private double[] calcDistancesByTypes() {
        double[] distances = new double[ActivityType.values().length];
        for (Activity activity : activityList) {
            distances[activity.getType().ordinal()] += activity.getDistance();
        }
        return distances;
    }

    public int numberOfTrackActivities() {
        int count = 0;
        for (Activity activity : activityList) {
            if (activity instanceof ActivityWithTrack) {
                count++;
            }
        }
        return count;
    }

    public int numberOfWithoutTrackActivities() {
        int count = 0;
        for (Activity activity : activityList) {
            if (activity instanceof ActivityWithoutTrack) {
                count++;
            }
        }
        return count;
    }
}
