package week14.d02.midlevel;

import java.util.*;

public class Order implements Comparable<Order> {

    private final String id;
    private final Set<String> orderedGoods = new TreeSet<>();

    public Order(String id, String... goods) {
        this.id = id;
        orderedGoods.addAll(Arrays.asList(goods));
    }

    public String getId() {
        return id;
    }

    public Set<String> getOrderedGoods() {
        return new TreeSet<>(orderedGoods);
    }

    @Override
    public String toString() {
        return id + " " + orderedGoods;
    }

    @Override
    public int compareTo(Order o) {
        return id.compareTo(o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
