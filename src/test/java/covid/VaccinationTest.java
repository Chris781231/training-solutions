package covid;

import covid.dao.VaccinationDao;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

public class VaccinationTest {

    private VaccinationDao vaccinationDao;
    private MariaDbDataSource dataSource;

    @BeforeEach
    void init() {
        dataSource = new MariaDbDataSource();

        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3308/covid?useUnicode=true");
            dataSource.setUser("covid");
            dataSource.setPassword("covid");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot create dataSource", sqle);
        }

        vaccinationDao = new VaccinationDao(dataSource);

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();
    }
}
