package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class Performance {

    private LocalDate date;
    private String artist;
    private LocalTime startTime;
    private LocalTime endTime;

    public Performance(LocalDate date, String artist, LocalTime startTime, LocalTime endTime) {
        this.date = date;
        this.artist = artist;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getArtist() {
        return artist;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getInfo() {
        return getArtist() + ": " +
                getDate() + " " +
                getStartTime() + " - " +
                getEndTime();
    }
}
