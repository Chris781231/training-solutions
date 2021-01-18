package week11.d02.midlevel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RideTest {

    Ride ride = new Ride(1, 1, 10);

    @Test
    void getDayOfWeek() {
        assertEquals(1, ride.getDayOfWeek());
    }

    @Test
    void getRideOfDay() {
        assertEquals(1, ride.getRideOfDay());
    }

    @Test
    void getDistanceInKm() {
        assertEquals(10, ride.getDistanceInKm());
    }
}