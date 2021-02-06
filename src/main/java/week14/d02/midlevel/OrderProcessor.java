package week14.d02.midlevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class OrderProcessor {

    public static final String ID_ORDERED_GOODS_SEPARATOR = " ";
    public static final String ORDERED_GOODS_ELEMENTS_SEPARATOR = ",";
    public static final int INDEX_OF_ID = 0;
    public static final int INDEX_OF_ORDERED_GOODS = 1;

    public static final int INITIAL_COUNT = 0;

    private final Set<Order> orders = new TreeSet<>();

    public void readFileFromResources(String path) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(path)))) {
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
            addCountToOrder(numbersOfGoods, order);
        }

        return numbersOfGoods;
    }

    private void addCountToOrder(Map<String, Integer> numbersOfGoods, Order order) {
        for (String elementOfOrderedGoods : order.getOrderedGoods()) {
            if (!isExistKey(numbersOfGoods, elementOfOrderedGoods)) {
                createKey(numbersOfGoods, elementOfOrderedGoods);
            }

            int value = numbersOfGoods.get(elementOfOrderedGoods);
            numbersOfGoods.put(elementOfOrderedGoods, ++value);
        }
    }

    private boolean isExistKey(Map<String, Integer> numbersOfGoods, String elementOfOrderedGoods) {
        return numbersOfGoods.containsKey(elementOfOrderedGoods);
    }

    private void createKey(Map<String, Integer> numbersOfGoods, String elementOfOrderedGoods) {
        numbersOfGoods.put(elementOfOrderedGoods, INITIAL_COUNT);
    }

    private void processLine(String line) {
        String[] elementOfOrder = line.split(ID_ORDERED_GOODS_SEPARATOR);
        String[] orderedGoods = elementOfOrder[INDEX_OF_ORDERED_GOODS].split(ORDERED_GOODS_ELEMENTS_SEPARATOR);

        orders.add(new Order(elementOfOrder[INDEX_OF_ID], orderedGoods));
    }
}
