package clone.timesheetitem;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeSheetItem {

    private final String employee;
    private final String project;
    private LocalDateTime from;
    private LocalDateTime to;

    public TimeSheetItem(String employee, String project, LocalDateTime from, LocalDateTime to) {
        this.employee = employee;
        this.project = project;
        this.from = from;
        this.to = to;
    }

    public TimeSheetItem(TimeSheetItem another) {
        this.employee = another.employee;
        this.project = another.project;
        this.from = another.from;
        this.to = another.to;
    }

    public static TimeSheetItem withDifferentDay(TimeSheetItem another, LocalDate localDate) {
        TimeSheetItem timeSheetItem = new TimeSheetItem(another);
        timeSheetItem.from = LocalDateTime.of(localDate, timeSheetItem.from.toLocalTime());
        timeSheetItem.to = LocalDateTime.of(localDate, timeSheetItem.to.toLocalTime());
        return timeSheetItem;
    }

    public String getEmployee() {
        return employee;
    }

    public String getProject() {
        return project;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    @Override
    public String toString() {
        return employee + " " + project + " " + from + " " + to;
    }
}
