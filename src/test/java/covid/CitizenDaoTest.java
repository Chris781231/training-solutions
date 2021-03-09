package covid;

import covid.dao.CitizenDao;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CitizenDaoTest {

    private CitizenDao citizenDao;
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

        citizenDao = new CitizenDao(dataSource);

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();
    }

    @Test
    void saveCitizen() {
        List<Long> ids = new ArrayList<>();
        ids.add(citizenDao.saveCitizen(new Citizen("John Doe", "2600", 42, "johndoe@mail.com", new SsnNumberGenerator().createSsnNumberByRandom())));
        ids.add(citizenDao.saveCitizen(new Citizen("Jane Doe", "2600", 25, "janedoe@mail.com", new SsnNumberGenerator().createSsnNumberByRandom())));
        ids.add(citizenDao.saveCitizen(new Citizen("Jack Doe", "2600", 67, "jackdoe@mail.com", new SsnNumberGenerator().createSsnNumberByRandom())));
        ids.add(citizenDao.saveCitizen(new Citizen("Joe Doe", "2600", 25, "joedoe@mail.com", new SsnNumberGenerator().createSsnNumberByRandom())));
        assertEquals(4, ids.size());
    }

    @Test
    void listCitizens() {
        citizenDao.saveCitizen(new Citizen("John Doe", "2600", 42, "johndoe@mail.com", new SsnNumberGenerator().createSsnNumberByRandom()));
        citizenDao.saveCitizen(new Citizen("Jane Doe", "2600", 25, "janedoe@mail.com", new SsnNumberGenerator().createSsnNumberByRandom()));
        citizenDao.saveCitizen(new Citizen("Jack Doe", "2600", 67, "jackdoe@mail.com", new SsnNumberGenerator().createSsnNumberByRandom()));
        assertEquals(3, citizenDao.listCitizens().size());
    }

    @Test
    void findCitizensByPostCode() {
        citizenDao.saveCitizen(new Citizen("John Doe", "2600", 42, "johndoe@mail.com", new SsnNumberGenerator().createSsnNumberByRandom()));
        citizenDao.saveCitizen(new Citizen("Jane Doe", "2618", 25, "janedoe@mail.com", new SsnNumberGenerator().createSsnNumberByRandom()));
        citizenDao.saveCitizen(new Citizen("Jack Doe", "2600", 67, "jackdoe@mail.com", new SsnNumberGenerator().createSsnNumberByRandom()));
        List<Citizen> result = citizenDao.findCitizensByPostCode("2600");
        assertEquals(2, result.size());
    }

    @Test
    void findCitizensByPostCodeFilteredByVaccination() {
        citizenDao.saveCitizen(new Citizen("John Doe", "2600", 42, "johndoe@mail.com", new SsnNumberGenerator().createSsnNumberByRandom()));
        citizenDao.saveCitizen(new Citizen("Jane Doe", "2618", 25, "janedoe@mail.com", new SsnNumberGenerator().createSsnNumberByRandom()));
        citizenDao.saveCitizen(new Citizen("Jack Doe", "2600", 67, "jackdoe@mail.com", new SsnNumberGenerator().createSsnNumberByRandom()));
        List<Citizen> result = citizenDao.findCitizensByPostCodeFilteredByVaccination("2600");
        assertEquals(2, result.size());
        assertEquals(67, result.get(0).getAge());
    }
}