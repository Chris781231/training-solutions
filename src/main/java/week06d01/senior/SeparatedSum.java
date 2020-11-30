package week06d01.senior;

public class SeparatedSum {

    public SeparatedSumBySign sum(String s) {
        if (!isValid(s)) {
            throw new IllegalArgumentException("The string must not be null or empty!");
        }

        double[] floatingNumbers = splitStringToFloatingNumbers(s);
        SeparatedSumBySign separatedSumBySign = new SeparatedSumBySign();

        for (double floatingNumber : floatingNumbers) {
            if (floatingNumber > 0) {
                separatedSumBySign.addPositiveNum(floatingNumber);
            } else {
                separatedSumBySign.addNegativeNum(floatingNumber);
            }
        }

        return separatedSumBySign;
    }

    private boolean isValid(String s) {
        return s != null && !s.isBlank();
    }

    private double[] splitStringToFloatingNumbers(String s) {
        String sWithDecimalPoint = s.replace(",", ".");
        String[] floatingNumberStrings = sWithDecimalPoint.split(";");
        double[] floatingNumbers = new double[floatingNumberStrings.length];

        for (int i = 0; i < floatingNumberStrings.length; i++) {
            floatingNumbers[i] = Double.parseDouble(floatingNumberStrings[i]);
        }

        return floatingNumbers;
    }
}
