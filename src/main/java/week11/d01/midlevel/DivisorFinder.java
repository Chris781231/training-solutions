package week11.d01.midlevel;

public class DivisorFinder {

    public int findDivisors(int n) {
        int number = n;
        int divisorCount = 0;

        while (number > 0) {
            int remainder = number % 10;
            if ((remainder != 0) && (n % remainder == 0)) {
                divisorCount++;
            }
            number /= 10;
        }

        return divisorCount;
    }
}
