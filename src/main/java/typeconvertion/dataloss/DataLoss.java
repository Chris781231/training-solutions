package typeconvertion.dataloss;

public class DataLoss {

    public static final int MAX_OF_COUNT = 3;

    public static void dataLoss() {
        long l = 0;

        for (long count = 0; count < MAX_OF_COUNT; ) {
            float f = l;
            long lConverted = (long) f;

            if (l != lConverted) {
                System.out.printf("Original: %d, in binary: %s%n", l, Long.toBinaryString(l));
                System.out.printf("Original: %d, in binary: %s%n", lConverted, Long.toBinaryString(lConverted));
                count++;
            }
            l++;
        }
    }

    public static void main(String[] args) {
        dataLoss();
    }
}
