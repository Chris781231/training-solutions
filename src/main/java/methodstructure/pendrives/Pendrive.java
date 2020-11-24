package methodstructure.pendrives;

public class Pendrive {

    private final String name;
    private final int capacity;
    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    public void risePrice(int percent) {
        price += price * percent / 100;
    }

    public int comparePricePerCapacity(Pendrive pendrive) {
        double actualPriceValueRatio = (double) price / capacity;
        double paramPriceValueRatio = (double) pendrive.price / pendrive.capacity;
        if (actualPriceValueRatio > paramPriceValueRatio) {
            return 1;
        }
        if (actualPriceValueRatio < paramPriceValueRatio) {
            return -1;
        }
        return 0;
    }

    public boolean cheaperThan(Pendrive pendrive) {
        return price < pendrive.price;
    }

    @Override
    public String toString() {
        return String.format("%s (%d GB): %d Ft", name, capacity, price);
    }
}
