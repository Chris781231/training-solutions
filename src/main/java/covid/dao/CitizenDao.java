package covid.dao;

import covid.Citizen;
import covid.service.Validation;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitizenDao {

    public static final String DATABASE_ACCESS_ERROR = "Adatbázis kapcsolati hiba!";
    public static final String MISSING_RECORD = "Nincs találat az adatbázisban!";

    private MariaDbDataSource dataSource;

    public CitizenDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public long saveCitizen(Citizen citizen) throws IllegalStateException {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO `citizens` (`citizen_name`, `zip`, `age`, `email`, `taj`, `number_of_vaccination`) VALUES (?, ?, ?, ?, ?, ?);",
                        Statement.RETURN_GENERATED_KEYS)
        ) {
            stmt.setString(1, citizen.getName());
            stmt.setString(2, citizen.getPostCode());
            stmt.setInt(3, citizen.getAge());
            stmt.setString(4, citizen.getEmail());
            stmt.setString(5, citizen.getSsnNumber());
            stmt.setInt(6, 0);
            stmt.executeUpdate();
            return getIdByStatement(stmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException(DATABASE_ACCESS_ERROR, sqle);
        } catch (IllegalStateException ise) {
            throw ise;
        }
    }

    public void updateCitizen(Connection conn, long citizenId) throws IllegalStateException {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE `citizens` SET `number_of_vaccination` = ?, `last_vaccination` = CURDATE() WHERE `citizen_id` = ?;")) {
            int numberOfVaccination = getNumberOfVaccinationByCitizen(conn, citizenId);
            if (numberOfVaccination >= 2) {
                throw new IllegalStateException("Kétszer beoltva! Több oltás nem lehetséges!");
            }
            stmt.setInt(1, ++numberOfVaccination);
            stmt.setLong(2, citizenId);
            stmt.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalStateException(DATABASE_ACCESS_ERROR, sqle);
        }
    }

    public List<Citizen> listCitizens() throws IllegalStateException {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `citizens` ORDER BY `citizen_id`;")
        ) {
            return selectCitizensByPreparedStatement(stmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException(DATABASE_ACCESS_ERROR, sqle);
        }
    }

    public List<Citizen> findCitizensByPostCode(String postCode) throws IllegalStateException {
        List<Citizen> result;
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `citizens` WHERE `zip` = ? ORDER BY `citizen_id`")
        ) {
            stmt.setString(1, postCode);
            result = selectCitizensByPreparedStatement(stmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException(DATABASE_ACCESS_ERROR, sqle);
        }
        return result;
    }

    public List<Citizen> findCitizensByPostCodeFilteredByVaccination(String postCode) throws IllegalStateException {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `citizens` WHERE (`zip` = ?) AND ((`number_of_vaccination` = 0) OR (`number_of_vaccination` = 1 AND DATEDIFF(NOW(), `last_vaccination`) >= 15)) ORDER BY `number_of_vaccination`, `age` DESC, `citizen_name` LIMIT 16")
        ) {
            stmt.setString(1, postCode);
            return selectCitizensByPreparedStatement(stmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException(DATABASE_ACCESS_ERROR, sqle);
        }
    }

    public Citizen findCitizenBySsnNumber(String ssnNumber) throws IllegalStateException {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `citizens` WHERE `taj` = ?;")
        ) {
            stmt.setString(1, ssnNumber);
            List<Citizen> citizens = selectCitizensByPreparedStatement(stmt);
            if (citizens.size() == 1) {
                return citizens.get(0);
            }
            throw new IllegalStateException(MISSING_RECORD);
        } catch (SQLException sqle) {
            throw new IllegalStateException(DATABASE_ACCESS_ERROR, sqle);
        }
    }

    public long getCitizenIdBySsnNumber(String ssnNumber) throws IllegalStateException {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT `citizen_id` FROM `citizens` WHERE `taj` = ?;")
        ) {
            stmt.setString(1, ssnNumber);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getLong(1);
            }
            throw new IllegalStateException(MISSING_RECORD);
        } catch (SQLException sqle) {
            throw new IllegalStateException(DATABASE_ACCESS_ERROR, sqle);
        }
    }

    public boolean isContainSsnNumber(String ssnNumber) throws IllegalStateException, IllegalArgumentException {
        if (Validation.isValidSsnNumber(ssnNumber)) {
            Citizen citizenBySsnNumber = findCitizenBySsnNumber(ssnNumber);
            System.out.println(citizenBySsnNumber);
        } else {
            throw new IllegalArgumentException("Hibás TAJ szám!");
        }
        return true;
    }

    private int getNumberOfVaccinationByCitizen(Connection conn, long citizenId) throws IllegalStateException {
        try (PreparedStatement stmt = conn.prepareStatement("SELECT `number_of_vaccination` FROM `citizens` WHERE `citizen_id` = ?")) {
            stmt.setLong(1, citizenId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("number_of_vaccination");
            }
            throw new IllegalStateException(MISSING_RECORD);
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

    private List<Citizen> selectCitizensByPreparedStatement(PreparedStatement stmt) throws IllegalStateException {
        List<Citizen> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                result.add(new Citizen(
                        rs.getString("citizen_name"),
                        rs.getString("zip"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getString("taj"),
                        rs.getInt("number_of_vaccination"),
                        rs.getTimestamp("last_vaccination") != null ? rs.getTimestamp("last_vaccination").toLocalDateTime().toLocalDate() : null
                ));
            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalStateException(DATABASE_ACCESS_ERROR, sqle);
        }
    }
}
