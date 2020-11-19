package stringmethods;

public class UrlManager {

    private String protocol;
    private String host;
    private Integer port;
    private String path;
    private String query;

    public UrlManager(String url) { // HTTPS://EarthQuake.USgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02
        String temp = url;

        if (!temp.contains("://") || temp.endsWith("://")) {
            throw new IllegalArgumentException("Invalid url");
        }

        temp = setProtocol(temp);
        temp = setHostAndPort(temp);

        if (temp != null) {
            setPathAndQuery(temp);
        }
    }

    private String setProtocol(String temp) {
        protocol = temp.substring(0, temp.indexOf("://")).toLowerCase();
        return temp.substring(protocol.length() + 3);
    }

    private String setHostAndPort(String temp) {
        if (temp.contains("/") && temp.contains(":")) {
            host = temp.substring(0, temp.indexOf(":")).toLowerCase();
            port = Integer.parseInt(temp.substring(temp.indexOf(":") + 1, temp.indexOf("/")));
            return temp.substring(host.length() + 1 + port.toString().length());
        }
        if (temp.contains("/")) {
            host = temp.substring(0, temp.indexOf("/")).toLowerCase();
            port = null;
            return temp.substring(host.length());
        }
        if (temp.contains(":")) {
            host = temp.substring(0, temp.indexOf(":")).toLowerCase();
            port = Integer.parseInt(temp.substring(host.length() + 1));
            path = "";
            query = "";
            return null;
        }
        host = temp;
        port = null;
        path = "";
        query = "";
        return null;
    }

    private void setPathAndQuery(String temp) {
        if (temp.contains("?") && temp.indexOf("?") != 0) {
            path = temp.substring(0, temp.indexOf("?"));
            query = temp.substring(path.length());
            return;
        }
        if (!temp.contains("?")) {
            path = temp;
            query = "";
            return;
        }
        path = "";
        query = temp;
    }

    public String getProtocol() {
        return protocol;
    }

    public Integer getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public boolean hasProperty(String key) {
        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException();
        }
        return query.contains("?" + key + "=") || query.contains("&" + key + "=");
    }

    public String getProperty(String key) {
        if (hasProperty(key)) {
            int valueStartIndex = query.indexOf(key) + key.length() + 1;
            int valueEndIndex = query.indexOf("&", valueStartIndex);
            return query.substring(valueStartIndex, valueEndIndex);
        }
        return null;
    }
}
