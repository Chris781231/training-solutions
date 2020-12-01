package week06d02.senior;

public class StoredProductsByCategory {

    private final Category category;
    private int amount = 0;

    public StoredProductsByCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public int getAmount() {
        return amount;
    }

    public void addAmount() {
        amount++;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", category, amount);
    }
}
