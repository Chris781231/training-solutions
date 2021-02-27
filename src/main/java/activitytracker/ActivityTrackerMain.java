package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class ActivityTrackerMain {

    public static void main(String[] args) {
        MariaDbDataSource dataSource;

        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3308/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException throwables) {
            throw new IllegalStateException("Cannot create dataSource");
        }

        ActivityTrackerDao activityTrackerDao = new ActivityTrackerDao(dataSource);
        activityTrackerDao.saveActivity(new Activity(LocalDateTime.of(2021, 11, 15, 10, 0), "No description", Type.BIKING));
        System.out.println(activityTrackerDao.listActivities());
        System.out.println(activityTrackerDao.findActivitiesByType(Type.HIKING));
    }
}
