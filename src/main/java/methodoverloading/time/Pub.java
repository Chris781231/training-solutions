package methodoverloading.time;

public class Pub {

    private final String name;
    private final Time openTime;

    public Pub(String name, int hours, int minutes) {
        this.name = name;
        this.openTime = new Time(hours, minutes);
    }

    public String getName() {
        return name;
    }

    public Time getOpenFrom() {
        return openTime;
    }

    @Override
    public String toString() { // Kurta kocsma;10:30
        return String.format("%s;%d:%d", name, openTime.getHours(), openTime.getMinutes());
    }
}
