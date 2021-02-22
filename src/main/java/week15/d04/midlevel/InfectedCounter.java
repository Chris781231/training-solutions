package week15.d04.midlevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class InfectedCounter {

    private int tempCounterForWeeklyCases = 0;
    private final List<CovidCaseByWeek> casesByWeek = new ArrayList<>();

    public static final String COUNTRY = "HUNGARY";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                InfectedCounter.class.getResourceAsStream("data.csv")))) {
            InfectedCounter counter = new InfectedCounter();
            counter.readFromFile(reader);

            System.out.println(counter.casesByWeek);

            List<CovidCaseByWeek> threeLargestNumberOfCases = counter.getThreeLargestNumberOfCases();
            System.out.println(threeLargestNumberOfCases);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    public void readFromFile(BufferedReader reader) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toUpperCase().contains(',' + COUNTRY + ',')) {
                    processLine(line);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot find file", ioe);
        }
    }

    public List<CovidCaseByWeek> getThreeLargestNumberOfCases() {
        List<CovidCaseByWeek> sortedCasesByWeek = new ArrayList<>(casesByWeek);
        Collections.sort(sortedCasesByWeek);
        List<CovidCaseByWeek> result = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            result.add(sortedCasesByWeek.get(i));
        }

        return result;
    }

    private void processLine(String line) {
        String[] temp = line.split(",");
        LocalDate date = LocalDate.of(Integer.parseInt(temp[3]), Integer.parseInt(temp[2]), Integer.parseInt(temp[1]));
        int caseCount = Integer.parseInt(temp[4]);
        String weekOfYear = date.getYear() + "-" + date.get(WeekFields.of(new Locale("HU", "hu")).weekOfYear());

        System.out.println(caseCount + " " + weekOfYear + date.getDayOfWeek());

        tempCounterForWeeklyCases += caseCount;
        if (date.getDayOfWeek() == DayOfWeek.MONDAY) {
            casesByWeek.add(new CovidCaseByWeek(COUNTRY, weekOfYear, tempCounterForWeeklyCases));
            tempCounterForWeeklyCases = 0;
        }
    }
}
