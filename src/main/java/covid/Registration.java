package covid;

import covid.dao.CitizenDao;
import covid.dao.ZipCodesCitiesDao;
import covid.service.Validation;
import org.mariadb.jdbc.MariaDbDataSource;

import java.util.List;
import java.util.Scanner;

public class Registration {

    private final Scanner scanner = new Scanner(System.in);

    private final ZipCodesCitiesDao zipCodesCitiesDao;
    private final CitizenDao citizenDao;

    public Registration(MariaDbDataSource dataSource) {
        this.zipCodesCitiesDao = new ZipCodesCitiesDao(dataSource);
        this.citizenDao = new CitizenDao(dataSource);
    }

    public void readFromConsole() throws IllegalStateException {
        String name = getNameFromConsole();
        String postCode = getPostCodeFromConsole();
        int age = getAgeFromConsole();
        String email = getEmailFromConsole("Email");
        String emailAgain = getEmailFromConsole("Email újra");
        while (!Validation.equalEmails(email, emailAgain)) {
            email = getEmailFromConsole("Email");
            emailAgain = getEmailFromConsole("Email újra");
        }
        String ssnNumber = getSsnFromConsole();
        try {
            citizenDao.saveCitizen(new Citizen(name, postCode, age, email, ssnNumber));
        } catch (IllegalStateException ise) {
            throw ise;
        }
        new CovidMain().run();
    }

    private String getNameFromConsole() {
        System.out.print("Név: ");
        String name = scanner.nextLine();
        while (!Validation.isValidName(name)) {
            System.out.println("Név nem lehet üres!");
            name = scanner.nextLine();
        }
        return name;
    }

    private String getPostCodeFromConsole() throws IllegalStateException {
        System.out.print("Irányítószám: ");
        String zip = scanner.nextLine();
        while (!Validation.isValidZip(zip)) {
            System.out.println("Irányítószám nem lehet üres!");
            zip = scanner.nextLine();
        }
        try {
            List<String> city = zipCodesCitiesDao.findCityByZip(zip);
            if (city.isEmpty()) {
                throw new IllegalStateException("Hibás irányítószám!");
            }
            System.out.println("Település: " + city);
        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
            getPostCodeFromConsole();
        }
        return zip;
    }


    private int getAgeFromConsole() {
        System.out.print("Életkor: ");
        int age = 0;
        try {
            age = Integer.parseInt(scanner.nextLine());
            while (!Validation.isValidAge(age)) {
                System.out.println("Az életkor 10 és 150 között kell legyen!");
                age = Integer.parseInt(scanner.nextLine());
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Kérem számokkal adja meg az életkort!");
        }
        return age;
    }

    private String getEmailFromConsole(String message) {
        System.out.print(message + ": ");
        String email = scanner.nextLine();
        while (!Validation.isValidEmail(email)) {
            System.out.println("Az email nem lehet üres, minimum 3 karakter, és tartalmaznia kell `@` karaktert!");
            email = scanner.nextLine();
        }
        return email;
    }

    private String getSsnFromConsole() {
        System.out.print("TAJ szám: ");
        String ssn = scanner.nextLine();
        while (!Validation.isValidSsnNumber(ssn)) {
            System.out.println("Hibás TAJ szám!");
            ssn = scanner.nextLine();
        }
        return ssn;
    }
}
