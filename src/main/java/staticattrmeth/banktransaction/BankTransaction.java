package staticattrmeth.banktransaction;

public class BankTransaction {

    private static final long POSSIBLE_MIN_VALUE = 1;
    private static final long POSSIBLE_MAX_VALUE = 10_0000_000;
    private static long currentMinValue = POSSIBLE_MAX_VALUE;
    private static long currentMaxValue = POSSIBLE_MIN_VALUE;
    private static int countTrx = 0;
    private static long sumOfTrxs = 0;

    private final long trxValue;

    public BankTransaction(long trxValue) {
        if (trxValue < POSSIBLE_MIN_VALUE || trxValue > POSSIBLE_MAX_VALUE) {
            throw new IllegalArgumentException("The value must be between 1 and 10 000 000");
        }
        this.trxValue = trxValue;
        countTrx++;
        sumOfTrxs += trxValue;
        if (trxValue < currentMinValue) {
            currentMinValue = trxValue;
        }
        if (trxValue > currentMaxValue) {
            currentMaxValue = trxValue;
        }
    }

    public static void initTheDay() {
        currentMinValue = POSSIBLE_MAX_VALUE;
        currentMaxValue = POSSIBLE_MIN_VALUE;
        countTrx = 0;
        sumOfTrxs = 0;
    }

    public static long averageOfTransaction() {
        if (countTrx < 1) {
            return 0;
        }
        return sumOfTrxs / countTrx;
    }

    public static long getCurrentMinValue() {
        if (countTrx < 1) {
            return 0;
        }
        return currentMinValue;
    }

    public static long getCurrentMaxValue() {
        if (countTrx < 1) {
            return 0;
        }
        return currentMaxValue;
    }

    public static long getSumOfTrxs() {
        return sumOfTrxs;
    }

    public long getTrxValue() {
        return trxValue;
    }
}
