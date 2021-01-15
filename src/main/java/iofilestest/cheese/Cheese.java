package iofilestest.cheese;

import java.util.Objects;

public class Cheese {

    private final String name;
    private final double lactose;

    public Cheese(String name, double lactose) {
        this.name = name;
        this.lactose = lactose;
    }

    public String getName() {
        return name;
    }

    public double getLactose() {
        return lactose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cheese cheese = (Cheese) o;
        return Double.compare(cheese.lactose, lactose) == 0 &&
                Objects.equals(name, cheese.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lactose);
    }

    @Override
    public String toString() {
        return "Cheese{" +
                "name='" + name + '\'' +
                ", lactose=" + lactose +
                '}';
    }
}
