package week06d05.midlevel;

public class Biscuit {

    private final BiscuitType type;
    private final int gramAmount;

    private Biscuit(BiscuitType type, int gramAmount) {
        this.type = type;
        this.gramAmount = gramAmount;
    }

    public static Biscuit of(BiscuitType type, int gramAmount) {
        return new Biscuit(type, gramAmount);
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", type, gramAmount);
    }
}
