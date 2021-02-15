package exam03;

public class Boat {

    private final String name;
    private final int maxPassenger;

    public Boat(String name, int maxPassenger) {
        this.name = name;
        this.maxPassenger = maxPassenger;
    }

    public String getName() {
        return name;
    }

    public int getMaxPassengers() {
        return maxPassenger;
    }
}
