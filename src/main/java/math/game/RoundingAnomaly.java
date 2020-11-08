package math.game;

import java.util.Random;

public class RoundingAnomaly {

    Random rnd = new Random();

    public double[] randomNumbers(int size, double max, int scale) {
        double[] rndNumbers = new double[size];

        for (int i = 0; i < size; i++) {
            rndNumbers[i] = Math.round(rnd.nextDouble() * max * Math.pow(10, scale)) / Math.pow(10, scale);
        }

        return rndNumbers;
    }

    public double roundAfterSum(double[] numbers) {
        double sum = 0;
        for (double value: numbers) {
            sum += value;
        }
        return Math.round(sum);
    }

    public double sumAfterRound(double[] numbers) {
        double sum = 0;
        for (double value: numbers) {
            sum += Math.round(value);
        }
        return sum;
    }

    public double difference(int size, double max, int scale) {
        double[] numbers = randomNumbers(size, max, scale);
        return Math.abs(roundAfterSum(numbers) - sumAfterRound(numbers));
    }


    public static void main(String[] args) {

        RoundingAnomaly ra = new RoundingAnomaly();
        double sum = 0;
        int count = 100;

        for (int i = 0; i < count; i++) {
            sum += ra.difference(1000, 1_000_000, 5);
        }

        System.out.println(sum / count);
    }
}
