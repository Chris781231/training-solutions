package initializer.creditcard;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {

    public static final List<Rate> ACTUAL_RATES = new ArrayList<>();

    // Set default conversion factor
    static {
        ACTUAL_RATES.add(new Rate(Currency.HUF, 1.0));
        ACTUAL_RATES.add(new Rate(Currency.EUR, 308.23));
        ACTUAL_RATES.add(new Rate(Currency.SFR, 289.24));
        ACTUAL_RATES.add(new Rate(Currency.GBP, 362.23));
        ACTUAL_RATES.add(new Rate(Currency.USD, 289.77));
    }

    private double balance;

    public CreditCard(long amount, Currency currency, List<Rate> rates) {
        this.balance = amount * getConversionRate(currency, rates);
    }

    public CreditCard(long balance, Currency currency) {
        this(balance, currency, ACTUAL_RATES);
    }

    public CreditCard(long balance) {
        this(balance, Currency.HUF, ACTUAL_RATES);
    }

    public double getBalance() {
        return balance;
    }

    public boolean payment(long amount, Currency currency, List<Rate> rates) {
        double withdraw = amount * getConversionRate(currency, rates);
        if (balance > withdraw) {
            balance -= withdraw;
            return true;
        }
        return false;
    }

    public boolean payment(long amount, Currency currency) {
        return payment(amount, currency, ACTUAL_RATES);
    }

    public boolean payment(long amount) {
        return payment(amount, Currency.HUF, ACTUAL_RATES);
    }

    private double getConversionRate(Currency currency, List<Rate> rates) {
        for (Rate rate : rates) {
            if (rate.getCurrency() == currency) {
                return rate.getConversionFactor();
            }
        }
        throw new IllegalArgumentException("Invalid currency!" + currency.name());
    }
}
