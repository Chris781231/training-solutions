package week05d03;

import java.util.List;

public class UserValidator {

    public boolean validate(List<User> users) {
        if (users == null || users.isEmpty()) {
            throw new IllegalArgumentException("Users must not be empty or invalid!");
        }

        for (User user : users) {
            if (user.getName() == null || user.getName().isBlank()) {
                throw new IllegalArgumentException("Name must not be empty!");
            }
            if (user.getAge() < 0 || user.getAge() > 120) {
                throw new IllegalArgumentException("Age must be between 0 and 120!");
            }
        }
        return true;
    }
}
