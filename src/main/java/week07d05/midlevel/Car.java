package week07d05.midlevel;

public class Car extends Vehicle {

    public Car(int numberOfGears, TransmissionType transmissionType) {
        super(numberOfGears, transmissionType);
    }

    public Car(TransmissionType transmissionType) {
        super(transmissionType);
    }

    public Car() {
        super(TransmissionType.AUTOMATIC);
    }
}
