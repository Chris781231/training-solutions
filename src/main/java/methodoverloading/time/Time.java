package methodoverloading.time;

public class Time {

    private final int hours;
    private final int minutes;
    private final int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = 0;
    }

    public Time(int hours) {
        this.hours = hours;
        this.minutes = 0;
        this.seconds = 0;
    }

    public Time(Time time) {
        this.hours = time.hours;
        this.minutes = time.minutes;
        this.seconds = time.seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public boolean isEqual(int hours, int minutes, int seconds) {
        return this.hours == hours &&
                this.minutes == minutes &&
                this.seconds == seconds;
    }

    public boolean isEqual(Time time) {
        return isEqual(time.hours, time.minutes, time.seconds);
    }

    public boolean isEarlier(int hours, int minutes, int seconds) {
        return (this.hours < hours) ||
                (this.hours == hours && this.minutes < minutes) ||
                (this.hours == hours && this.minutes == minutes && this.seconds < seconds);
    }

    public boolean isEarlier(Time time) {
        return isEarlier(time.hours, time.minutes, time.seconds);
    }
}
