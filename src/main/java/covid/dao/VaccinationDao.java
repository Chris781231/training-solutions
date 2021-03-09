package covid.dao;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDate;

public class VaccinationDao {

    public static final String DATABASE_ACCESS_ERROR = "Adatbázis kapcsolati hiba!";
    public static final String MISSING_RECORD = "Nincs találat az adatbázisban!";

    private final MariaDbDataSource dataSource;
    private final CitizenDao citizenDao;

    public VaccinationDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
        this.citizenDao = new CitizenDao(dataSource);
    }


    public long saveVaccionation(String ssnNumber, LocalDate date, String vaccina) throws IllegalStateException {
        long citizenId = citizenDao.getCitizenIdBySsnNumber(ssnNumber);
        long vaccinationId;

        try (Connection conn = dataSource.getConnection()) {
            try {
                conn.setAutoCommit(false);

                vaccinationId = insertVaccination(conn, citizenId, date, vaccina);

                citizenDao.updateCitizen(conn, citizenId);

                conn.commit();
                return vaccinationId;
            } catch (SQLException sqle) {
                conn.rollback();
                throw new IllegalStateException(DATABASE_ACCESS_ERROR, sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException(DATABASE_ACCESS_ERROR, sqle);
        }
    }

    public void saveFailedVaccionation(String ssnNumber, LocalDate date, String note) throws IllegalStateException {
        long citizenId = citizenDao.getCitizenIdBySsnNumber(ssnNumber);

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO `vaccinations` (`citizen_id`, `vaccination_date`, `note`) VALUES (?, ?, ?);")
        ) {
            stmt.setLong(1, citizenId);
            stmt.setDate(2, Date.valueOf(date));
            stmt.setString(3, note);
            stmt.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalStateException(DATABASE_ACCESS_ERROR, sqle);
        }
    }

    private long insertVaccination(Connection conn, long citizenId, LocalDate date, String vaccina) throws IllegalStateException {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO `vaccinations` (`citizen_id`, `vaccination_date`, `vaccination_type`) VALUES (?, ?, ?);",
                Statement.RETURN_GENERATED_KEYS)) {
            stmt.setLong(1, citizenId);
            stmt.setDate(2, Date.valueOf(date));
            stmt.setString(3, vaccina);
            stmt.executeUpdate();
            return getIdByStatement(stmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException(DATABASE_ACCESS_ERROR, sqle);
        }
    }

    private long getIdByStatement(PreparedStatement stmt) throws IllegalStateException {
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getLong(1);
            }
            throw new IllegalStateException(MISSING_RECORD);
        } catch (SQLException sqle) {
            throw new IllegalStateException(DATABASE_ACCESS_ERROR, sqle);
        }
    }
}
