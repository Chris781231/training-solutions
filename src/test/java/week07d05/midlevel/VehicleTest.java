package week07d05.midlevel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    Vehicle car = new Car();
    Vehicle manualCar = new Car(6, TransmissionType.MANUAL);
    Vehicle truck = new Truck();
    Vehicle motorcycle = new Motorcycle();

    @Test
    void getTransmissionTypeTest() {
        assertEquals(TransmissionType.AUTOMATIC, car.getTransmissionType());
        assertEquals(TransmissionType.MANUAL, manualCar.getTransmissionType());
        assertEquals(TransmissionType.MANUAL, truck.getTransmissionType());
        assertEquals(TransmissionType.SEQUENTIAL, motorcycle.getTransmissionType());
    }

    @Test
    void getNumberOfGearsTest() {
        assertEquals(5, car.getNumberOfGears());
        assertEquals(6, manualCar.getNumberOfGears());
        assertEquals(5, truck.getNumberOfGears());
        assertEquals(5, motorcycle.getNumberOfGears());
    }
}