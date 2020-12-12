package week07d05.midlevel;

public abstract class Vehicle {

    private final int numberOfGears;
    private final TransmissionType transmissionType;

    protected Vehicle(int numberOfGears, TransmissionType transmissionType) {
        this.numberOfGears = numberOfGears;
        this.transmissionType = transmissionType;
    }

    protected Vehicle(TransmissionType transmissionType) {
        this(5, transmissionType);
    }

    protected Vehicle() {
        this(5, TransmissionType.MANUAL);
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }
}
