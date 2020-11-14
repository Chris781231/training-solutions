package enumtype.unit;

import java.util.ArrayList;
import java.util.List;

public enum LengthUnit {
    MILLIMETER(true, 1),
    CENTIMETER(true, 10),
    METER(true, 1000),
    YARD(false, 914.4),
    FOOT(false, 304.8),
    INCH(false, 25.4);

    private final boolean isSI;
    private final double inMillimeter;

    LengthUnit(boolean isSI, double inMillimeter) {
        this.isSI = isSI;
        this.inMillimeter = inMillimeter;
    }

    public boolean isSI() {
        return isSI;
    }

    public double getInMillimeter() {
        return inMillimeter;
    }

    public static List<LengthUnit> siUnits() {
        List<LengthUnit> siLengthUnits = new ArrayList<>();

        for (LengthUnit lengthUnit: LengthUnit.values()) {
            if (lengthUnit.isSI()) {
                siLengthUnits.add(lengthUnit);
            }
        }

        return siLengthUnits;
    }
}
