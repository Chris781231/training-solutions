package week13.d02.midlevel;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightTest {

    private final Flight flight = new Flight("FC5354", Status.ARRIVAL, "Dublin", LocalDateTime.now().withHour(18).withMinute(16));

    @Test
    void getFlightNumber() {
        assertEquals("FC5354", flight.getFlightNumber());
    }

    @Test
    void getStatus() {
        assertEquals(Status.ARRIVAL, flight.getStatus());
    }

    @Test
    void getCity() {
        assertEquals("Dublin", flight.getCity());
    }

    @Test
    void getTime() {
        assertEquals(18, flight.getTime().getHour());
        assertEquals(16, flight.getTime().getMinute());
    }
}