package literals;

public class LiteralsMain {

    public static void main(String[] args) {

        // Concatenation
        System.out.println("1" + "2");
        System.out.println("1" + 2);
        System.out.println(1 + "2");
        System.out.println("1".concat("2"));

        // Division
        double quotient = 3 / 4;        // The result is 0.0, because both of 3 and 4 are integer type literal, so the result will be an integer, even though I store it in a double type.
        System.out.println(quotient);
        quotient = (double) 3 / 4;      // The Solution is that one of the members of the literal must be of type double.
        System.out.println(quotient);
        // OR
        quotient = 3.0 / 4;               // or (3 / 4.0)
        System.out.println(quotient);

        // Big number
        long big = 3_244_444_444L;
    }
}
