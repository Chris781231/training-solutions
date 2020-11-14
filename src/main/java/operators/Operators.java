package operators;

public class Operators {

    // Even number
    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    // Stepping operators
    public int multiplyByPowerOfTwo(int number, int power) {
        return number << power;
    }

    // Bonus
    /*
     * Must to use Long wrapper because the JVW does not know about passed String that it is a negative number,
     * it does not use binary complement, it treats it as a positive number. 2 ^ 32 = 4_294_967_296, this number
     * does not fit in Integer's value set.
     */

    public void partOfCode() {
        int i = -10;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        int j = Long.valueOf(s, 2).intValue();
//        int j = Integer.parseInt(s, 2);
        System.out.println(j);
    }
}
