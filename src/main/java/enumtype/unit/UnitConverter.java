package enumtype.unit;

import mathrandom.MathRandomMain;

public class UnitConverter {

    public static final int SCALE = 4;

    double convert(double length, LengthUnit source, LengthUnit target) {
        double lengthInMillimeter = length * source.getInMillimeter();
        double convertedLength = lengthInMillimeter / target.getInMillimeter();

        return MathRandomMain.roundWithFixDecimal(convertedLength, SCALE);
    }
}
