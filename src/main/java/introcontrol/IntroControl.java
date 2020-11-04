package introcontrol;

public class IntroControl {

    public static int substractTenIfGreaterThanTen(int number) {
        if (number <= 10) {
            return number;
        }
        return number - 10;
    }

    public static String describeNumber(int number) {
        if (number == 0) {
            return "zero";
        }
        return "not zero";
    }

    public static String greetingToJoe(String name) {
        if (name.equals("Joe")) {
            return "Joe";
        }
        return "";
    }

    public static int calculateBonus(int sale) {
        if (sale >= 1_000_000) {
            return (int) (sale * 0.1);
        }
        return 0;
    }

    public static int calculateConsumption(int prev, int next) {
        if (next > prev) {
            return next - prev;
        }
        return 10000 + next - prev;
    }

    public static void printNumbers(int max) {
        for (int i = 0; i <= max; i++) {
            System.out.println(i);
        }
    }

    public static void printNumbersBetween(int a, int b) {
        for (int i = a; i <= b; i++) {
            System.out.println(i);
        }
    }

    public static void printNumbersBetweenAnyDirection(int a, int b) {
        if (a < b) {
            for (int i = a; i <= b; i++) {
                System.out.println(i);
            }
        } else if (a > b) {
            for (int i = a; i >= b; i--) {
                System.out.println(i);
            }
        } else {
            System.out.println(a);
        }
    }

    public static void printOddNumbers(int max) {
        for (int i = 1; i <= max; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }
    }
}
