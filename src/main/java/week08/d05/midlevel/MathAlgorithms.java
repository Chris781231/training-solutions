package week08.d05.midlevel;

public class MathAlgorithms {

    public int getGreatestCommonDivisor(int num1, int num2) { // Euclides's algorithm
        checkNumbers(num1, num2);
        if (num1 < num2) { // change numbers
            num1 += num2;
            num2 = num1 - num2;
            num1 -= num2;
        }

        int remainder;
        while ((remainder = num1 % num2) > 0) {
            num1 = num2;
            num2 = remainder;
        }

        return num2;
    }

    private void checkNumbers(int num1, int num2) {
        if (num1 <= 0 || num2 <= 0) {
            throw new IllegalArgumentException("Each of num1 and num2 must be natural numbers");
        }
    }

    public static void main(String[] args) {
        System.out.println(new MathAlgorithms().getGreatestCommonDivisor(24, 15));
    }
}
