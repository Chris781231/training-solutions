package introcontrol;

public class IntroControlMain {

    public static void main(String[] args) {

        System.out.println(IntroControl.substractTenIfGreaterThanTen(8));
        System.out.println(IntroControl.substractTenIfGreaterThanTen(35));

        System.out.println(IntroControl.describeNumber(0));
        System.out.println(IntroControl.describeNumber(2));

        System.out.println("Hello " + IntroControl.greetingToJoe("Joe") + "!");
        System.out.println("Hello " + IntroControl.greetingToJoe("Jack") + "!");

        System.out.println(IntroControl.calculateBonus(2_000_000));
        System.out.println(IntroControl.calculateBonus(999_999));

        System.out.println(IntroControl.calculateConsumption(4500, 5000));
        System.out.println(IntroControl.calculateConsumption(5000, 4500));

        IntroControl.printNumbers(15);

        IntroControl.printNumbersBetween(3, 8);

        IntroControl.printNumbersBetweenAnyDirection(3, 8);
        IntroControl.printNumbersBetweenAnyDirection(8, 3);

        IntroControl.printOddNumbers(15);
    }
}
