package constructoroverloading.bustimetable;

import constructoroverloading.simpletime.SimpleTime;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {

    private List<SimpleTime> timeTable;

    public BusTimeTable(List<SimpleTime> timeTable) {
        this.timeTable = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {
        List<SimpleTime> timeTable = new ArrayList<>();

        for (int i = firstHour; i <= lastHour; i++) {
            timeTable.add(new SimpleTime(i, everyMinute));
        }

        this.timeTable = timeTable;
    }

    public SimpleTime nextBus(SimpleTime actual) {
        for (int i = 0; i < timeTable.size(); i++) {
            if (timeTable.get(i).difference(actual) >= 0) {
                return timeTable.get(i);
            }
        }
        throw new IllegalStateException("No more buses today!");
    }

    public SimpleTime firstBus() {
        SimpleTime firstBusTime = null;

        for (SimpleTime time : timeTable) {
            if (firstBusTime == null || time.difference(firstBusTime) < 0) {
                firstBusTime = time;
            }
        }

        return firstBusTime;
    }

    public List<SimpleTime> getTimeTable() {
        return timeTable;
    }
}
