package operators;

public class OperatorsMain {

    public static void main(String[] args) {

        // Even number
        System.out.println(new Operators().isEven(2));
        System.out.println(new Operators().isEven(5));

        // Stepping operators
        System.out.println(Integer.toBinaryString(16));
        System.out.println(Integer.toBinaryString(16 >>> 1));
        System.out.println(Integer.toBinaryString(16 >> 1));
        System.out.println(Integer.toBinaryString(16 << 1));
        System.out.println(Integer.toBinaryString(13));
        System.out.println(Integer.toBinaryString(13 >>> 1));
        System.out.println(Integer.toBinaryString(13 >> 1));
        System.out.println(Integer.toBinaryString(13 << 1));

        System.out.printf("10 * 2 ^ 2 = %d\n", new Operators().multiplyByPowerOfTwo(10, 2));

        // Bonus
        new Operators().partOfCode();

        // Bonus 2
        /*
         * The output is 219, because the '0' prefix means the number system is octal.
         */
        System.out.println(0333);
    }
}
