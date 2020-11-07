package math.game;

public class Game {

    public static void main(String[] args) {

        Warrior joe = new Warrior("Joe", new Point(3, 4));
        Warrior jack = new Warrior("Jack", new Point(0, 0));

        System.out.println("Initial settings:");
        System.out.println(joe);
        System.out.println(jack);

        for (int round = 1; joe.isAlive() && jack.isAlive(); round++) {

            System.out.println("Round " + round);
            if (joe.isAlive()) {
                if (joe.distance(jack) > 0) {
                    joe.move(jack);
                } else {
                    joe.attack(jack);
                }
                System.out.println(joe);
            }

            if (jack.isAlive()) {
                if (jack.distance(joe) > 0) {
                    jack.move(joe);
                } else {
                    jack.attack(joe);
                }
            }
            System.out.println(jack);
        }

        System.out.println("The winner is: " + (joe.isAlive() ? "Joe" : "Jack"));
    }
}
