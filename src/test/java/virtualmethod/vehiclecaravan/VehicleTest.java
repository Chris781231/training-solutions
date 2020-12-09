package virtualmethod.vehiclecaravan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleTest {

    @Test
    public void getGrossLoad() {
        Vehicle vehicle = new Vehicle(1000);

        assertEquals(1000 + Vehicle.PERSON_AVERAGE_WEIGHT, vehicle.getGrossLoad());
    }

    @Test
    public void getVehicleWeight() {
        Vehicle vehicle = new Vehicle(1000);

        assertEquals(1000, vehicle.getVehicleWeight());
    }

    @Test
    public void tostring() {
        Vehicle vehicle = new Vehicle(1000);

        assertEquals("Vehicle{vehicleWeight=" + 1000 + '}', vehicle.toString());
    }
}