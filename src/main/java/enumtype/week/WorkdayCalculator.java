package enumtype.week;

import java.util.ArrayList;
import java.util.List;

public class WorkdayCalculator {

    List<DayType> dayTypes(Day firstDay, int numberOfDays) {
        List<DayType> types = new ArrayList<>();
        Day actualDay = firstDay;

        for (int i = 0; i < numberOfDays; i++) {
            types.add(actualDay.getDayType());
            actualDay = Day.FRIDAY.nextDay(actualDay);
        }

        return types;
    }
}
