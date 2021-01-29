package collectionsmap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class LogParser {

    public static final int NUMBER_OF_FIELDS = 3;
    public static final int POSITION_OF_IP = 0;
    public static final int POSITION_OF_DATE = 1;
    public static final int POSITION_OF_LOGIN = 2;
    public static final String FIELD_SEPARATOR = ":";
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ISO_DATE;

    public Map<String, List<Entry>> parseLog(String log) {
        if (!isValidLog(log)) {
            throw new IllegalArgumentException("Incorrect log: log is empty");
        }
        try (Scanner scanner = new Scanner(log)) {
            Map<String, List<Entry>> entries = new HashMap<>();

            while (scanner.hasNext()) {
                String line = scanner.next();
                String[] lineItems = line.split(FIELD_SEPARATOR);
                if (lineItems.length != NUMBER_OF_FIELDS) {
                    throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
                }
                LocalDate entryDate = parseDate(lineItems[POSITION_OF_DATE]);
                Entry entry = new Entry(lineItems[POSITION_OF_IP], entryDate, lineItems[POSITION_OF_LOGIN]);
                if (!entries.containsKey(entry.getIpAddress())) {
                    entries.put(entry.getIpAddress(), new ArrayList<>());
                }
                entries.get(entry.getIpAddress()).add(entry);
            }
            return entries;
        }
    }

    private LocalDate parseDate(String date) {
        try {
            return LocalDate.parse(date, DATE_FORMAT);
        } catch (DateTimeParseException dtpe) {
            throw new IllegalArgumentException("Incorrect log: incorrect date", dtpe);
        }
    }

    private boolean isValidLog(String log) {
        return (log != null && !log.isBlank());
    }
}
