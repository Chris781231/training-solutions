package week06d05.senior;

public enum BottleType {

    GLASS_BOTTLE (330),
    PET_BOTTLE (500);

    private final int maximumAmount;

    BottleType(int maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public int getMaximumAmount() {
        return maximumAmount;
    }
}
