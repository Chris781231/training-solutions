package enumtype.week;

import java.util.ArrayList;
import java.util.List;

public class WorkdayCalculator {

    List<DayType> dayTypes(Day firstDay, int numberOfDays) {
        List<DayType> types = new ArrayList<>();
        Day actualDay = firstDay;

        for (int i = 0; i < numberOfDays; i++) {
            types.add(actualDay.getDayType());
            actualDay = nextDay(actualDay);
        }

        return types;
    }

    private Day nextDay(Day actualDay) {
        if (actualDay.ordinal() == Day.values().length - 1) {
            return Day.values()[0];
        } else {
            return Day.values()[actualDay.ordinal() + 1];
        }
    }
}
