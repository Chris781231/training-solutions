package covid;

import java.util.HashMap;
import java.util.Map;

public class Report {

    private String zip;
    private Map<Integer, Integer> citizens;

    public Report(String zip, Map<Integer, Integer> citizens) {
        this.zip = zip;
        this.citizens = citizens;
    }

    public String getZip() {
        return zip;
    }

    public Map<Integer, Integer> getCitizens() {
        return new HashMap<>(citizens);
    }
}
