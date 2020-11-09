package primitivetypes;

public class PrimitiveTypes {

    public static final int NUMBER_OF_BITS = 32;

    public String toBinaryString(int n) {

        boolean isNegative = (n < 0 ? true : false);
        String nToBinaryString = "";

        for (int quotient = Math.abs(n); quotient > 0; quotient /= 2) {
            nToBinaryString = (quotient % 2) + nToBinaryString;
        }

        // Addition to 32 bit
        int additionalBitCount = NUMBER_OF_BITS - nToBinaryString.length();
        for (int i = 0; i < additionalBitCount; i++) {
            nToBinaryString = "0" + nToBinaryString;
        }

        if (isNegative) {
            nToBinaryString = toTwoComplementer(nToBinaryString);
        }

        return nToBinaryString;
    }

    private String toTwoComplementer(String nToBinaryString) {

        // Swap
        String swappedBinaryString = "";
        for (int i = 0; i < nToBinaryString.length(); i++) {
            if (nToBinaryString.charAt(i) == '0') {
                swappedBinaryString += "1";
            } else {
                swappedBinaryString += "0";
            }
        }

        // Add 1
        String twoComplementBinaryString = "";
        boolean isOne = true;
        for (int i = NUMBER_OF_BITS - 1; i >= 0; i--) {
            if (isOne) {
                if (swappedBinaryString.charAt(i) == '0') {
                    twoComplementBinaryString = "1" + twoComplementBinaryString;
                    isOne = false;
                } else {
                    twoComplementBinaryString = "0" + twoComplementBinaryString;
                }
            } else {
                twoComplementBinaryString = swappedBinaryString.charAt(i) + twoComplementBinaryString;
            }
        }

        return twoComplementBinaryString;
    }

    public static void main(String[] args) {

        PrimitiveTypes pt = new PrimitiveTypes();
        System.out.println(pt.toBinaryString(-123456));
        System.out.println(Integer.toBinaryString(-123456));
    }
}
