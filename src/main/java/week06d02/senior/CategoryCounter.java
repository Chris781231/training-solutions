package week06d02.senior;

public class CategoryCounter {

    private final Category category;
    private final int counter;

    public CategoryCounter(Category category, int counter) {
        this.category = category;
        this.counter = counter;
    }

    public Category getCategory() {
        return category;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", category, counter);
    }
}
