package week05d05;

public class User {

    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email) {
        if (isEmpty(firstName) || isEmpty(lastName) || isEmpty(email)) {
            throw new IllegalArgumentException("All data must be provided!");
        }
        this.firstName = firstName;
        this.lastName = lastName;

        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Email must contain '@' and '.' characters!");
        }
        this.email = email;
    }

    public boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    public String getEmail() {
        return email;
    }
}
