package week15.d04.midlevel;

import java.util.Objects;

public class CovidCaseByWeek implements Comparable<CovidCaseByWeek> {

    private final String country;
    private final String week;
    private final int caseCount;

    public CovidCaseByWeek(String country, String week, int caseCount) {
        this.country = country;
        this.week = week;
        this.caseCount = caseCount;
    }

    public String getCountry() {
        return country;
    }

    public String getWeek() {
        return week;
    }

    public int getCaseCount() {
        return caseCount;
    }

    @Override
    public String toString() {
        return country + " - " + week + "(" + caseCount + ")";
    }

    @Override
    public int compareTo(CovidCaseByWeek o) {
        return o.caseCount - this.caseCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CovidCaseByWeek that = (CovidCaseByWeek) o;
        return caseCount == that.caseCount && Objects.equals(country, that.country) && Objects.equals(week, that.week);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, week, caseCount);
    }
}
