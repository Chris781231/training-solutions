package inheritancemethods.productpackedproduct;

import java.math.BigDecimal;

public class PackedProduct extends Product {

    private final int packingUnit;
    private final BigDecimal weightOfBox;

    public PackedProduct(String name, BigDecimal unitWeight, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeight, numberOfDecimals);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    public PackedProduct(String name, BigDecimal unitWeight, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeight);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    public int getPackingUnit() {
        return packingUnit;
    }

    public BigDecimal getWeightOfBox() {
        return weightOfBox;
    }

    @Override
    public BigDecimal totalWeight(int pieces) {
        int sumOfBoxes = (pieces % packingUnit) == 0 ? (pieces / packingUnit) : (pieces / packingUnit + 1);
        BigDecimal weightOfBoxes = BigDecimal.valueOf(sumOfBoxes).multiply(weightOfBox);
        return super.totalWeight(pieces).add(weightOfBoxes);
    }
}
