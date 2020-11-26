package week05d04.midlevel;

import java.time.LocalDate;

public class Product {

    private final String name;
    private final LocalDate expireDate;

    public Product(String name, int year, int month, int day) {
        this.name = name;
        this.expireDate = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }
}
