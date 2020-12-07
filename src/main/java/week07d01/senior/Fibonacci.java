package week07d01.senior;

public class Fibonacci {

    /**
     * Utility classes, which are collections of static members, are not meant to be instantiated.
     * Even abstract utility classes, which can be extended, should not have public constructors.
     * Java adds an implicit public constructor to every class which does not define at least one explicitly.
     * Hence, at least one non-public constructor should be defined.
     */
    private Fibonacci() {
        throw new IllegalArgumentException("Utility class");
    }

    public static long fibLoop(int n) {
        if (n < 0) {throw new IllegalArgumentException("Too low number! Minimum number is 0!");}
        if (n == 0) {return 0;}
        if (n == 1) {return 1;}

        long nMinusTwoFib = 0;
        long nMinusOneFib = 1;
        long nthFibonacci = nMinusOneFib + nMinusTwoFib;

        int i = 3;
        while (i <= n) {
            nMinusTwoFib = nMinusOneFib;
            nMinusOneFib = nthFibonacci;
            nthFibonacci = nMinusOneFib + nMinusTwoFib;
            i++;
        }

        return nthFibonacci;
    }

    public static long fibRecursion(int n) {
        if (n < 0) {throw new IllegalArgumentException("Too low number! Minimum number is 0!");}
        if (n == 0) {return 0;}
        if (n == 1) {return 1;}

        return fibRecursion(n - 1) + fibRecursion(n - 2);
    }
}
