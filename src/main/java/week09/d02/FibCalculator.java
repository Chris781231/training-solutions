package week09.d02;

public class FibCalculator {

    public long sumEvens(int bound) {
        if (bound < 0) throw new IllegalArgumentException("Number must be natural number");
        if (bound == 0) return 0;
        if (bound == 1) return 1;

        long nMinusTwoFib = 0;
        long nMinusOneFib = 1;
        long nthFib = nMinusTwoFib + nMinusOneFib;
        long sumFib = 0;

        while (nthFib <= bound) {
            if (nthFib % 2 == 0) {
                sumFib += nthFib;
            }
            nMinusTwoFib = nMinusOneFib;
            nMinusOneFib = nthFib;
            nthFib = nMinusTwoFib + nMinusOneFib;
        }
        return sumFib;
    }
}
