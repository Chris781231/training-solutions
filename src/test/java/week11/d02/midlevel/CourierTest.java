package week11.d02.midlevel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CourierTest {

    @Test
    void addRide() {
        Courier courier = new Courier();
        courier.addRide(1, 1, 10);
        courier.addRide(1, 2, 12);
        System.out.println(courier.getRides());
        assertEquals(2, courier.getRides().size());
        assertEquals(10, courier.getRides().get(0).getDistanceInKm());
        assertEquals(2, courier.getRides().get(1).getRideOfDay());
    }

    @Test
    void findFirstDayOff() {
        Courier courier = new Courier();
        courier.addRide(1, 1, 10);
        courier.addRide(1, 2, 5);
        courier.addRide(2, 1, 8);
        courier.addRide(5, 1, 12);
        assertEquals(3, courier.findFirstDayOff());
    }
}