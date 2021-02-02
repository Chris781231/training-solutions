package properties.javatools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class JavaTools {

    public static final Charset CHARSET = StandardCharsets.UTF_8;
    Properties javaToolsProp = new Properties();

    public JavaTools() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream("/javatools.properties"), CHARSET))) {
            javaToolsProp.load(reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file from classpath", ioe);
        }
    }

    public Set<String> getToolKeys() {
        Set<String> toolKeys = new HashSet<>();

        Set<String> keys = javaToolsProp.stringPropertyNames();
        for (String key : keys) {
            toolKeys.add(key.substring(0, key.indexOf(".")));
        }

        return toolKeys;
    }

    public Set<String> getTools() {
        Set<String> tools = new HashSet<>();

        for (String key : getToolKeys()) {
            tools.add(getName(key));
        }

        return tools;
    }

    public String getName(String searchedKey) {
        return javaToolsProp.getProperty(searchedKey + ".name");
    }

    public String getUrl(String searchedKey) {
        return javaToolsProp.getProperty(searchedKey + ".url");
    }
}
