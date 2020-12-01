package inheritancemethods.productpackedproduct;

import java.math.BigDecimal;

public class Product {

    private final String name;
    private final BigDecimal unitWeight;
    private final int numberOfDecimals;

    public Product(String name, BigDecimal unitWeight, int numberOfDecimals) {
        this.name = name;
        this.unitWeight = unitWeight;
        this.numberOfDecimals = numberOfDecimals;
    }

    public Product(String name, BigDecimal unitWeight) {
        this(name, unitWeight,2);
    }

    public BigDecimal totalWeight(int pieces) {
        return new BigDecimal(pieces).multiply(unitWeight);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitWeight() {
        return unitWeight;
    }

    public int getNumberOfDecimals() {
        return numberOfDecimals;
    }
}
