package week04d01;

public class NameChanger {

    private String fullName;

    public NameChanger(String fullName) {
        if (fullName == null || fullName.isEmpty()) {
            throw new IllegalArgumentException("Invalid name: " + fullName);
        }
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void changeFirstName(String givenFirstName) {
        String[] name = fullName.split(" ");
        String newName = givenFirstName.concat(" ").concat(name[1]);
        setFullName(newName);
    }
}
