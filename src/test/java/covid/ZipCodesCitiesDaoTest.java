package covid;

import covid.dao.ZipCodesCitiesDao;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZipCodesCitiesDaoTest {

    ZipCodesCitiesDao zipCodesCitiesDao;

    @BeforeEach
    void init() {
        MariaDbDataSource dataSource = new MariaDbDataSource();

        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3308/covid?useUnicode=true");
            dataSource.setUser("covid");
            dataSource.setPassword("covid");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot create dataSource", sqle);
        }

        zipCodesCitiesDao = new ZipCodesCitiesDao(dataSource);

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();
    }

    @Test
    void findCityByZip() {
        List<String> cityByZip = zipCodesCitiesDao.findCityByZip("2600");
        assertEquals("Vác", cityByZip.get(0));
    }
}