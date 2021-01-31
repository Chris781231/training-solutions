package week13.d02.midlevel;

import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {

    private final String flightNumber;
    private final Status status;
    private final String city;
    private final LocalDateTime time;

    public Flight(String flightNumber, Status status, String city, LocalDateTime time) {
        this.flightNumber = flightNumber;
        this.status = status;
        this.city = city;
        this.time = time;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Status getStatus() {
        return status;
    }

    public String getCity() {
        return city;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", status=" + status +
                ", city='" + city + '\'' +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(flightNumber, flight.flightNumber) && status == flight.status && Objects.equals(city, flight.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, status, city);
    }
}
