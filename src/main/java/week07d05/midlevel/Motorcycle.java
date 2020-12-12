package week07d05.midlevel;

public class Motorcycle extends Vehicle {

    public Motorcycle(int numberOfGears, TransmissionType transmissionType) {
        super(numberOfGears, transmissionType);
    }

    public Motorcycle(TransmissionType transmissionType) {
        super(transmissionType);
    }

    public Motorcycle() {
        super(TransmissionType.SEQUENTIAL);
    }
}
