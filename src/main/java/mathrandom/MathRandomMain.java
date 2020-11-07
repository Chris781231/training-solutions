package mathrandom;

import java.util.Random;

public class MathRandomMain {

    public static double roundWithFixDecimal(double number, int decimal) {
        number *= Math.pow(10, decimal);
        number = Math.round(number);
        number /= Math.pow(10, decimal);
        return number;
    }

    public static void main(String[] args) {

        System.out.println(roundWithFixDecimal(15.6543789, 3));
        System.out.println(roundWithFixDecimal(15.6547874, 3));

        System.out.println(new Random().nextInt(30) - 10);
        System.out.println(new Random().nextDouble() * 6 - 3);
    }
}
