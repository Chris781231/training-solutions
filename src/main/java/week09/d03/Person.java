package week09.d03;

import java.util.Random;

public class Person {

    private final String name;
    private final int age;
    private Present present;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setPresent() {
        Random random = new Random();
        if (age > 14) {
            present = Present.values()[random.nextInt(Present.values().length - 1) + 1];
        } else {
            present = Present.values()[random.nextInt(Present.values().length)];
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Present getPresent() {
        return present;
    }
}
