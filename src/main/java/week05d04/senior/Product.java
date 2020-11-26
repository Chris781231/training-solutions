package week05d04.senior;

public class Product {

    private static final double RATE = 300.0;

    private final long price;
    private final Currency currency;

    public Product(long price, Currency currency) {
        this.price = price;
        this.currency = currency;
    }

    public long getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double convertPrice(Currency currency) {
        double result = 0;
        if (this.currency == currency) {
            result = this.price;
        } else {
            if (currency == Currency.HUF) {
                result = this.price * RATE;
            } else if (currency == Currency.USD) {
                result = this.price / RATE;
            }
        }
        return result;
    }
}
