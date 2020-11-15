package introexception.patient;

public class Patient {


    private final String name;
    private final String socialSecurityNumber;
    private final int yearOfBirth;

    public Patient(String name, String socialSecurityNumber, int yearOfBirth) {
        if (!name.equals("")) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty!");
        }

        if (new SsnValidator().isValidSsn(socialSecurityNumber)) {
            this.socialSecurityNumber = socialSecurityNumber;
        } else {
            throw new IllegalArgumentException("Invalid Social Security Number: " + socialSecurityNumber);
        }

        if (yearOfBirth >= 1900) {
            this.yearOfBirth = yearOfBirth;
        } else {
            throw new IllegalArgumentException("Year of birth is at least 1900!");
        }
    }

    public String getName() {
        return this.name;
    }

    public String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
