package _demo;

import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class ActivityTrackerMain {

    public static final String PROPERTY_FILE = "db.xml";

    public String loadQueryFromFile(BufferedReader reader) {
        try {
            return reader.readLine();
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    public static void main(String[] args) {

        ActivityTrackerMain main = new ActivityTrackerMain();
        String query = "";

        MariaDbDataSource dataSource = new MariaDbDataSource();

        main.setConnection(dataSource);

        if (!query.equals("")) {
            main.runQuery(query, dataSource);
        }
    }

    private void runQuery(String query, MariaDbDataSource dataSource) {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    private String getQueryFromFile(String queryFile) {
        String query;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ActivityTrackerMain.class.getResourceAsStream(queryFile)))) {
            query = new ActivityTrackerMain().loadQueryFromFile(reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot find file", ioe);
        }
        return query;
    }

    private void setConnection(MariaDbDataSource dataSource) {
        Properties p = new Properties();
        try {
            p.loadFromXML(ActivityTrackerMain.class.getResourceAsStream(PROPERTY_FILE));
            String host = p.getProperty("host");
            String port = p.getProperty("port");
            String db = p.getProperty("database");
            String user = p.getProperty("user");
            String pass = p.getProperty("pass");
            dataSource.setUrl("jdbc:mariadb://" + host + ":" + port + "/" + db + "?useUnicode=true");
            dataSource.setUser(user);
            dataSource.setPassword(pass);
        } catch (InvalidPropertiesFormatException e) {
            throw new IllegalStateException("Invalid properties file format", e);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not create data source", sqle);
        }
    }
}
