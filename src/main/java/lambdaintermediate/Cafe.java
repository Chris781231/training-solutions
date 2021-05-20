package lambdaintermediate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {

    private final List<CoffeeOrder> coffeeOrders;

    public Cafe() {
        coffeeOrders = new ArrayList<>();
    }

    public Cafe(List<CoffeeOrder> coffeeOrders) {
        this.coffeeOrders = coffeeOrders;
    }

    public void addCoffeeOrder(CoffeeOrder order) {
        coffeeOrders.add(order);
    }

    public BigDecimal getTotalIncome() {
        return coffeeOrders.stream()
                .flatMap(l -> l.getCoffeeList().stream())
                .map(Coffee::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add, BigDecimal::add).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalIncome(LocalDate date) {
        return coffeeOrders.stream()
                .filter(o -> o.getDateTime().toLocalDate().equals(date))
                .flatMap(l -> l.getCoffeeList().stream())
                .map(Coffee::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add, BigDecimal::add).setScale(2, RoundingMode.HALF_UP);
    }

    public long getNumberOfCoffee(CoffeeType type) {
        return coffeeOrders.stream()
                .flatMap(l -> l.getCoffeeList().stream())
                .filter(c -> c.getType().equals(type))
                .count();
    }

    public Collection<Object> getOrdersAfter(LocalDateTime dateTime) {
        return coffeeOrders.stream()
                .filter(o -> o.getDateTime().isAfter(dateTime))
                .collect(Collectors.toList());
    }

    public List<CoffeeOrder> getFirstFiveOrder(LocalDate date) {
        return coffeeOrders.stream()
                .filter(o -> o.getDateTime().toLocalDate().equals(date))
                .sorted(Comparator.comparing(CoffeeOrder::getDateTime))
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<CoffeeOrder> getCoffeeOrders() {
        return new ArrayList<>(coffeeOrders);
    }
}
