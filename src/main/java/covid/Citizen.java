package covid;

import java.time.LocalDate;

public class Citizen {

    private long id;
    private final String name;
    private final String postCode;
    private final int age;
    private final String email;
    private final String ssnNumber;
    private int numberOfVaccination;
    private LocalDate lastVaccination;

    public Citizen(String name, String postCode, int age, String email, String ssnNumber) {
        this(name, postCode, age, email, ssnNumber, 0, null);
    }

    public Citizen(String name, String postCode, int age, String email, String ssnNumber, int numberOfVaccination, LocalDate lastVaccination) {
        this.name = name;
        this.postCode = postCode;
        this.age = age;
        this.email = email;
        this.ssnNumber = ssnNumber;
        this.numberOfVaccination = numberOfVaccination;
        this.lastVaccination = lastVaccination;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPostCode() {
        return postCode;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getSsnNumber() {
        return ssnNumber;
    }

    public int getNumberOfVaccination() {
        return numberOfVaccination;
    }

    public LocalDate getLastVaccination() {
        return lastVaccination;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNumberOfVaccination(int numberOfVaccination) {
        this.numberOfVaccination = numberOfVaccination;
    }

    public void setLastVaccination(LocalDate lastVaccination) {
        this.lastVaccination = lastVaccination;
    }

    @Override
    public String toString() {
        return "Név: " + name +
                ", irányítószám: " + postCode +
                ", életkor: " + age +
                ", email: " + email +
                ", TAJ szám: " + ssnNumber +
                ", korábbi oltások (COVID) száma: " + numberOfVaccination +
                ", utolsó oltás ideje: " + (lastVaccination == null ? "N/A" : lastVaccination);
    }
}
