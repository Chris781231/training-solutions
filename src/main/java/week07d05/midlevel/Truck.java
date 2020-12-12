package week07d05.midlevel;

public class Truck extends Vehicle {

    public Truck(int numberOfGears, TransmissionType transmissionType) {
        super(numberOfGears, transmissionType);
    }

    public Truck(TransmissionType transmissionType) {
        super(transmissionType);
    }

    public Truck() {
    }
}
