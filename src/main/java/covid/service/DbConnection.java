package covid.service;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

public class DbConnection {

    public static MariaDbDataSource createDataSource() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3308/covid?useUnicode=true");
            dataSource.setUser("covid");
            dataSource.setPassword("covid");
            return dataSource;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot create dataSource", sqle);
        }
    }
}
