package week05d03;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final String name;
    private final int age;
    private final List<User> users = new ArrayList<>();

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        users.add(this);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
