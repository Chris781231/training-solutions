package exceptionmulticatching.converter;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray (String binaryString) {
        if (binaryString == null) {
            throw new NullPointerException("binary string is null");
        }

        boolean[] booleans = new boolean[binaryString.length()];

        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) != '0' && binaryString.charAt(i) != '1') {
                throw new IllegalArgumentException("binary string is invalid");
            }
            booleans[i] = (binaryString.charAt(i) == '1');
        }

        return booleans;
    }

    public String booleanArrayToBinaryString(boolean[] booleans) {
        if (booleans == null) {
            throw new NullPointerException("boolean array is null");
        }
        if (booleans.length == 0) {
            throw new IllegalArgumentException("boolean array is invalid");
        }

        StringBuilder sb = new StringBuilder();

        for (boolean b : booleans) {
            sb.append(b ? '1' : '0');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        new BinaryStringConverter().binaryStringToBooleanArray("01111000");
    }
}
