package introinheritance.itembasketshoppingbasket;

import java.util.Locale;

public class Item {

    private final String barcode;
    private final double nettoPrice;
    private final int vatPercent;

    public Item(String barcode, double nettoPrice, int vatPercent) {
        this.barcode = barcode;
        this.nettoPrice = nettoPrice;
        this.vatPercent = vatPercent;
    }

    public String getBarcode() {
        return barcode;
    }

    public double getNettoPrice() {
        return nettoPrice;
    }

    public double getTaxAmount() {
        return nettoPrice * vatPercent / 100;
    }

    @Override
    public String toString() { // Item{barcode='123456', nettoPrice=1000.0, vatPercent=27}
        return String.format(Locale.US, "Item{barcode='%s', nettoPrice=%.1f, vatPercent=%d}", barcode, nettoPrice, vatPercent);
    }
}
