package week10.d05.midlevel;

public class Calculator {

    public int findMinSum(int[] numbers) {
        if (numbers.length < 4) {
            throw new IllegalArgumentException("Too few elements are in array");
        }

        sort(numbers);
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    private void sort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }
}
