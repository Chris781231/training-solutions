package recursion.faktorialis;

public class Factorial {

    public long getFactorialWithRecursion(int number) {
        if (number > 1) {
            return number * getFactorialWithRecursion(number - 1);
        } else {
            return 1;
        }
    }

    public long getFactorialWithLoop(int number) {
        long factorial = number;

        for (int i = number - 1; i > 0; i--) {
            factorial *= i;
        }

        return factorial;
    }
}
