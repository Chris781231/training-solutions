package finalmodifier;

public class TaxCalculator {

    public static final double VAT = 0.27;

    public double tax(double price) {
        return price / (1 + VAT);
    }

    public double priceWithTax(double price) {
        return price * (1 + VAT);
    }


    public static void main(String[] args) {

        System.out.println(new TaxCalculator().tax(127));
        System.out.println(new TaxCalculator().priceWithTax(100));
    }
}
