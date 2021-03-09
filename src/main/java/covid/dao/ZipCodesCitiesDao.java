package covid.dao;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZipCodesCitiesDao {

    public static final String DATABASE_ACCESS_ERROR = "Adatbázis kapcsolati hiba!";

    private MariaDbDataSource dataSource;

    public ZipCodesCitiesDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> findCityByZip(String zip) throws IllegalStateException {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT `telepules` FROM `iranyitoszamok_varosok_2021` WHERE `irsz` = ?")
        ) {
            stmt.setString(1, zip);
            return selectCitiesByPreparedStatement(stmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException(DATABASE_ACCESS_ERROR, sqle);
        }
    }

    private List<String> selectCitiesByPreparedStatement(PreparedStatement stmt) throws IllegalStateException {
        List<String> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                result.add(rs.getString("telepules"));
            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalStateException(DATABASE_ACCESS_ERROR, sqle);
        }
    }
}
