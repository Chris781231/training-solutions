package constructoroverloading.simpletime;

public class SimpleTime {

    public static final int MINUTES_IN_HOUR = 60;

    private int hours;
    private int minutes;

    public SimpleTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public SimpleTime(int hours) {
        this(hours, 0);
    }

    public SimpleTime(SimpleTime time) {
        this(time.hours, time.minutes);
    }

    public int difference(SimpleTime time) {
        return (this.hours - time.hours) * MINUTES_IN_HOUR + (this.minutes - time.minutes);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public String toString() {
        return String.format("%d:%d", hours, minutes);
    }
}
