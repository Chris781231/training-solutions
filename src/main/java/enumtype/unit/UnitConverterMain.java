package enumtype.unit;

public class UnitConverterMain {

    public static void main(String[] args) {

        System.out.println(new UnitConverter().convert(1, LengthUnit.INCH, LengthUnit.CENTIMETER));

        System.out.println(LengthUnit.siUnits());
    }
}
