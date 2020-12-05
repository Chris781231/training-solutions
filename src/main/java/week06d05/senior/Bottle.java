package week06d05.senior;

public class Bottle {

    private final BottleType type;
    private int filledUntil = 0;

    private Bottle(BottleType type) {
        this.type = type;
    }

    public static Bottle of(BottleType type) {
        return new Bottle(type);
    }

    public void fill(int fillAmount) {
        if (fillAmount > type.getMaximumAmount() - filledUntil) {
            throw new IllegalArgumentException("Too much liquid!");
        }

        filledUntil += fillAmount;
    }

    public BottleType getType() {
        return type;
    }

    public int getFilledUntil() {
        return filledUntil;
    }
}
