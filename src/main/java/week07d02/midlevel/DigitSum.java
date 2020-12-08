package week07d02.midlevel;

public class DigitSum {

    public int sumOfDigits(int number) {
        String xString = Integer.toString(number);
        int sum = 0;

        for (int i = 0; i < xString.length(); i++) {
            sum += Integer.parseInt(xString.substring(i, i + 1));
        }

        return sum;
    }

    public int sumOfDigitsRecursion(int number) {
        if (number / 10 == 0) {
            return number;
        }
        return sumOfDigitsRecursion(number / 10) + number % 10;
    }
}
