package math.game;

import java.util.Random;

public class Warrior {

    private final String name;
    private int stamina;
    private double skill;
    private Point position;

    Random rnd = new Random();

    public Warrior(String name, Point position) {
        this.name = name;
        this.position = position;
        stamina = rnd.nextInt(81) + 20;
        skill = rnd.nextDouble();
    }

    public Point getPosition() {
        return position;
    }

    public void move(Warrior warrior) {
        int thisPositionX = this.getPosition().getX();
        int thisPositionY = this.getPosition().getY();
        int warriorPositionX = warrior.getPosition().getX();
        int warriorPositionY = warrior.getPosition().getY();

        if (thisPositionY < warriorPositionY) {
            thisPositionY++;
        } else if (thisPositionY > warriorPositionY) {
            thisPositionY--;
        }
        if (thisPositionX < warriorPositionX) {
            thisPositionX++;
        } else if (thisPositionX > warriorPositionX) {
            thisPositionX--;
        }

        position = new Point(thisPositionX, thisPositionY);
    }

    public double distance(Warrior warrior) {
        return this.position.distance(warrior.position);
    }

    public void attack(Warrior warrior) {
        if (rnd.nextDouble() < skill) {
            warrior.stamina -= rnd.nextInt(3) + 1;
        }
    }

    public boolean isAlive() {
        return stamina > 0;
    }

    @Override
    public String toString() {
        return name + ": (" + position.getX() + "," + position.getY() + ") " + stamina;
    }
}
