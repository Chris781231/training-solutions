package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityTrackerMain {

    private final List<Activity>  activities = new ArrayList<>();
    private MariaDbDataSource dataSource;

    public static void main(String[] args) {

        ActivityTrackerMain main = new ActivityTrackerMain();
//        main.createTempActivities();
        main.buildConnection();
//        main.insertDataToTable();
//        main.findActivityById(1);
        System.out.println(main.findActivityById(4));
        System.out.println(main.getActivitiesFromDb());
    }

    public void createTempActivities() {
        activities.add(new Activity(0, LocalDateTime.of(2020, 11, 15, 16, 0), null, Type.BIKING));
        activities.add(new Activity(0, LocalDateTime.of(2020, 11, 16, 15, 45), null, Type.RUNNING));
        activities.add(new Activity(0, LocalDateTime.of(2020, 12, 23, 9, 0), null, Type.HIKING));
    }

    public void buildConnection() {
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3308/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot create dataSource", sqle);
        }
    }

    public void insertDataToTable() {
        for (Activity activity : activities) {
            try (
                    Connection conn = dataSource.getConnection();
                    PreparedStatement ps = conn.prepareStatement("INSERT INTO `activities` (start_time, activity_desc, activity_type) VALUES (?, ?, ?);")
            ) {
                ps.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
                ps.setString(2, activity.getDesc());
                ps.setString(3, activity.getType().toString());
                ps.executeUpdate();
            } catch (SQLException sqle) {
                throw new IllegalStateException("Cannot query", sqle);
            }
        }
    }

    public Activity findActivityById(int id) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM `activities` WHERE `id` = ? ORDER BY `id`")
        ) {
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                return getActivity(id, result);
            }
            throw new IllegalArgumentException("Not found");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    public List<Activity> getActivitiesFromDb() {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement()
        ) {
            ResultSet result = stmt.executeQuery("SELECT * FROM `activities` ORDER BY `id`");
            while (result.next()) {
                int id = result.getInt("id");
                activities.add(getActivity(id, result));
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }

        return activities;
    }

    private Activity getActivity(int id, ResultSet result) throws SQLException {
        LocalDateTime startTime = result.getTimestamp("start_time").toLocalDateTime();
        String desc = result.getString("activity_desc");
        Type type = Type.valueOf(result.getString("activity_type"));
        return new Activity(id, startTime, desc, type);
    }
}
