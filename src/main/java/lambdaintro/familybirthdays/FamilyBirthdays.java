package lambdaintro.familybirthdays;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.List;

public class FamilyBirthdays {

    List<LocalDate> birthdays;

    public FamilyBirthdays(LocalDate... dates) {
        birthdays = List.of(dates);
    }

    public boolean isFamilyBirthday(TemporalAccessor date) {
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);

        for (LocalDate birthday : birthdays) {
            if (birthday.getMonthValue() == month && birthday.getDayOfMonth() == day) {
                return true;
            }
        }
        return false;
    }

    public int nextFamilyBirthDay(TemporalAccessor date) {
        int year = date.get(ChronoField.YEAR);
        LocalDate actualDate = LocalDate.of(year, date.get(ChronoField.MONTH_OF_YEAR), date.get(ChronoField.DAY_OF_MONTH));
        int min = Integer.MAX_VALUE;

        for (LocalDate birthday : birthdays) {
            LocalDate nextBirthday = birthday.withYear(year);
            if (actualDate.isAfter(nextBirthday)) {
                nextBirthday = birthday.withYear(year + 1);
            }
            int diff = (int) ChronoUnit.DAYS.between(actualDate, nextBirthday);
            if (diff < min) {
                min = diff;
            }
        }

        return min;
    }
}
