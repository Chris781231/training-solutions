package properties.databaseconfig;

import java.io.*;
import java.util.Properties;

public class DatabaseConfiguration {

    Properties properties;

    public DatabaseConfiguration() {
        try (InputStream is = this.getClass().getResourceAsStream("/db.properties")) {
            load(is);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file from classpath", ioe);
        }
    }

    public DatabaseConfiguration(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            load(fis);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
    }

    private void load(InputStream is) {
        properties = new Properties();
        try (InputStreamReader reader = new InputStreamReader(is)) {
            properties.load(reader);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file from inputstream", ioe);
        }
    }

    public String getHost() {
        return properties.getProperty("db.host");
    }

    public int getPort() {
        return Integer.parseInt(properties.getProperty("db.port"));
    }

    public String getSchema() {
        return properties.getProperty("db.schema");
    }
}
