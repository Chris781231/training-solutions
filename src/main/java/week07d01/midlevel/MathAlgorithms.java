package week07d01.midlevel;

public class MathAlgorithms {

    public static boolean isPrime(int number) {
        if (Math.abs(number) < 2) {
            return false;
        }

        for (int i = 2; i <= Math.abs(number) / 2.0; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
