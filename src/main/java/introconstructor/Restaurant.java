package introconstructor;

import java.util.Arrays;
import java.util.List;

public class Restaurant {

    private List<String> menu;
    private String name;
    private int capacity;

    public Restaurant(String name, int numberOfTables) {
        this.name = name;
        capacity = numberOfTables * 4;
        menu = setMenu();
    }

    public List<String> setMenu() {
        return Arrays.asList("Sima hamburger", "Sajtos hamburger", "Dupla-húsos hamburger", "Dupla-sajtos hamburger", "Dupla-húsos-sajtos hamburger");
    }

    public List<String> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
               "menu=" + menu +
               ", name='" + name + '\'' +
               ", capacity=" + capacity +
               '}';
    }
}
