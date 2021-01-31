package week13.d02.midlevel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AirportManagerTest {

    private final AirportManager manager = new AirportManager();

    @BeforeEach
    void setUp() {
        manager.readFromFile(AirportManager.class.getResourceAsStream("/cities.txt"));
    }

    @Test
    void getMaxStatus() {
        assertEquals(Status.DEPARTURE, manager.getMaxStatus());
    }

    @Test
    void getFlightByFlightNumber() {
        assertEquals(new Flight("SW1667", Status.ARRIVAL, "Budapest", LocalDateTime.now()),
                manager.getFlightByFlightNumber("SW1667"));
    }

    @Test
    void getFlightsByCityAndStatus() {
        List<Flight> budapestArrival = manager.getFlightsByCityAndStatus("Budapest", Status.ARRIVAL);
        assertEquals(3, budapestArrival.size());
        assertEquals("PT4102", budapestArrival.get(0).getFlightNumber());
    }

    @Test
    void getEarlierDepartureFlight() {
        assertEquals("JE9763", manager.getEarlierDepartureFlight().getFlightNumber());
        assertEquals(Status.ARRIVAL, manager.getEarlierDepartureFlight().getStatus());
        assertEquals("Paris", manager.getEarlierDepartureFlight().getCity());
        assertEquals("06:01", manager.getEarlierDepartureFlight().getTime().toString().substring(11));
    }
}