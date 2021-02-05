package week14.d02.midlevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class OrderProcessor {

    public static final String FILENAME = "orders.txt";
    public static final String SEARCHED_ID = "b341";
    public static final String SEARCHED_GOODS = "sugar";
    private final Set<Order> orders = new TreeSet<>();

    public static void main(String[] args) {
        OrderProcessor op = new OrderProcessor();
        op.readFileFromResources();
        System.out.println("Orders: " + op.orders + "\n");
        System.out.println("OrderedGoods for " + SEARCHED_ID.toUpperCase() + ": " + op.getOrderedGoodsById(SEARCHED_ID) + "\n");
        System.out.println("Count of " + SEARCHED_GOODS + ": " + op.getCountOfGoodsByName(SEARCHED_GOODS) + "\n");
        System.out.println("Count of " + SEARCHED_ID.toUpperCase() + " order goods: " + op.getOrderedGoodsCountById(SEARCHED_ID) + "\n");
        System.out.println(op.reportOfOrderedGoods());
    }

    public void readFileFromResources() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(FILENAME)))) {
            String line;
            while ((line = br.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    public Set<String> getOrderedGoodsById(String id) {
        for (Order order : orders) {
            if (order.getId().equalsIgnoreCase(id)) {
                return order.getOrderedGoods();
            }
        }
        throw new IllegalArgumentException("Wrong parameter: " + id);
    }

    public int getCountOfGoodsByName(String name) {
        int count = 0;
        for (Order order : orders) {
            if (order.getOrderedGoods().contains(name)) {
                count++;
            }
        }
        return count;
    }

    public int getOrderedGoodsCountById(String id) {
        for (Order order : orders) {
            if (order.getId().equalsIgnoreCase(id)) {
                return order.getOrderedGoods().size();
            }
        }
        return 0;
    }

    public Map<String, Integer> reportOfOrderedGoods() {
        Map<String, Integer> numbersOfGoods = new TreeMap<>();

        for (Order order : orders) {
            for (String elementOfOrderedGoods : order.getOrderedGoods()) {
                if (!numbersOfGoods.containsKey(elementOfOrderedGoods)) {
                    numbersOfGoods.put(elementOfOrderedGoods, 1);
                } else {
                    int value = numbersOfGoods.get(elementOfOrderedGoods);
                    numbersOfGoods.put(elementOfOrderedGoods, ++value);
                }
            }
        }


        return numbersOfGoods;
    }

    private void processLine(String line) {
        String[] elementOfOrder = line.split(" ");
        String[] orderedGoods = elementOfOrder[1].split(",");

        orders.add(new Order(elementOfOrder[0], orderedGoods));
    }
}
