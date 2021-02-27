package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActivityTrackerDaoTest {

    private ActivityTrackerDao trackerDao;

    @BeforeEach
    void init() {
        MariaDbDataSource dataSource;

        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3308/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot create dataSource", sqle);
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        trackerDao = new ActivityTrackerDao(dataSource);
    }

    @Test
    void findActivityByIdTest() {
        trackerDao.saveActivity(new Activity(LocalDateTime.of(2020, 11, 15, 16, 0), "No description", Type.BIKING));
        Activity activityById = trackerDao.findActivityById(1);
        assertEquals(1, activityById.getId());
        assertEquals("2020-11-15T16:00", activityById.getStartTime().toString());
        assertEquals("No description", activityById.getDesc());
        assertEquals(Type.BIKING, activityById.getType());
    }

    @Test
    void getActivitiesTest() {
        trackerDao.saveActivity(new Activity(LocalDateTime.of(2020, 11, 15, 16, 0), "No description", Type.BIKING));
        trackerDao.saveActivity(new Activity(LocalDateTime.of(2020, 11, 16, 15, 45), "No description", Type.RUNNING));
        trackerDao.saveActivity(new Activity(LocalDateTime.of(2020, 12, 23, 9, 0), "No description", Type.HIKING));
        List<Activity> activities = trackerDao.listActivities();
        assertEquals(3, activities.size());
        assertEquals(3, activities.get(2).getId());
        assertEquals(Type.RUNNING, activities.get(1).getType());
    }
}