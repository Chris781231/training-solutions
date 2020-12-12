package exceptionclass.simpletime;

public class SimpleTime {

    private int hour;
    private int minute;

    public SimpleTime(int hour, int minute) {
        setTime(hour, minute);
    }

    public SimpleTime(String time) {
        if (time == null) {
            throw new InvalidTimeException("Time is null");
        }

        if (isInvalidTime(time)) {
            throw new InvalidTimeException("Time is not hh:mm");
        }

        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3));
        setTime(h, m);
    }

    private boolean isInvalidTime(String stringFormatTime) {
        if (stringFormatTime.length() != "hh:mm".length() || stringFormatTime.charAt(2) != ':') {
            return true;
        }
        try {
            Integer.parseInt(stringFormatTime.split(":")[0]);
            Integer.parseInt(stringFormatTime.split(":")[1]);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void setTime(int hour, int minute) {
        if (hour < 0 || hour > 23) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        if (minute < 0 || minute > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
}
