package week09.d02;

public class FibCalculator {

    public static int[] FIB_NUMS = new int[1000];

    public int sumEvens(int bound) {
        if (bound < 0 || bound >= FIB_NUMS.length) {
            throw new IllegalArgumentException("bound must be between 0 and 999");
        }
        int sum = 0;
        int fibN = 0;
        while (fibCalc(fibN) < bound) {
            if (fibN % 2 == 0) {
                sum += FIB_NUMS[fibN];
            }
            fibN++;
        }
        return sum;
    }

    private int fibCalc(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (FIB_NUMS[n] == 0) {
            FIB_NUMS[n] = fibCalc(n - 1) + fibCalc(n - 2);
        }
        return FIB_NUMS[n];
    }

    public static void main(String[] args) {
        FibCalculator fibCalculator = new FibCalculator();
        System.out.println(fibCalculator.sumEvens(2));
    }
}
