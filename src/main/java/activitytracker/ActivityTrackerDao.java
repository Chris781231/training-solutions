package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityTrackerDao {

    private final List<Activity> activities = new ArrayList<>();
    private MariaDbDataSource dataSource;

    public ActivityTrackerDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveActivity(Activity activity) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO `activities` (start_time, activity_desc, activity_type) VALUES(?, ?, ?)",
                        PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().toString());
            stmt.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot insert", sqle);
        }
    }

    public Activity findActivityById(long id) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `activities` WHERE `id` = ?")
        ) {
            stmt.setLong(1, id);
            List<Activity> result = selectActivitiesByPreparedStatement(stmt);
            if (result.size() == 1) {
                return result.get(0);
            }
            throw new IllegalStateException("Not found");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot select", sqle);
        }
    }

    public List<Activity> listActivities() {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `activities` ORDER BY `id`")
        ) {
            return selectActivitiesByPreparedStatement(stmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect", sqle);
        }
    }

    public List<Activity> findActivitiesByType(Type type) {
        try(
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `activities` WHERE `activity_type` = ?")
        ) {
            stmt.setString(1, type.toString());
            return selectActivitiesByPreparedStatement(stmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect", sqle);
        }
    }

    private List<Activity> selectActivitiesByPreparedStatement(PreparedStatement stmt) {
        List<Activity> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                result.add(new Activity(
                        rs.getLong("id"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("activity_desc"),
                        Type.valueOf(rs.getString("activity_type"))
                ));
            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot find id", sqle);
        }
    }
}
