package covid;

import covid.dao.CitizenDao;
import covid.dao.VaccinationDao;
import covid.service.DbConnection;
import covid.service.Services;
import covid.service.Validation;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CovidMain {

    private final Scanner scanner = new Scanner(System.in);
    private MariaDbDataSource dataSource;
    private CitizenDao citizenDao;
    private Services services;
    private VaccinationDao vaccinationDao;

    public CovidMain() {
        dataSource = DbConnection.createDataSource();
        citizenDao = new CitizenDao(dataSource);
        services = new Services(dataSource);
        vaccinationDao = new VaccinationDao(dataSource);
    }

    public static void main(String[] args) {

        new CovidMain().run();
    }

    public void run() {
        displayMenu();
        selectMenu();
    }

    private void displayMenu() {

        System.out.print("""
                                
                COVID-oltás alkalmazás
                                
                -----------------------
                1. Regisztráció
                2. Tömeges regisztráció
                3. Generálás
                4. Oltás
                5. Oltás meghiúsult
                6. Riportkészítés
                Egyéb billentyű: Kilépés
                -----------------------
                """);
        System.out.print(">>> ");
    }

    private void selectMenu() {
        switch (scanner.nextLine()) {
            case "1" -> {
                System.out.println("1. Regisztráció");
                registration();
            }
            case "2" -> {
                System.out.println("2. Tömeges regisztráció");
                multiplyRegistration();
            }
            case "3" -> {
                System.out.println("3. Generálás");
                generation();
            }
            case "4" -> {
                System.out.println("4. Oltás");
                vaccination();
            }
            case "5" -> {
                System.out.println("5. Oltás meghiúsult");
                failedVaccination();
            }
            case "6" -> {
                System.out.println("6. Riportkészítés");
                createReport();
            }
            default -> invalidParamFromScanner();
        }
    }

    private void registration() {
        try {
            new Registration(dataSource).readFromConsole();
        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
        }
        run();
    }

    private void multiplyRegistration() {
        System.out.print("Kérem a fájl nevét (elérési úttal): ");
        String fileName = scanner.nextLine();

        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
            List<Integer> failedLines = services.readFromFile(reader);
            System.out.println("Hibás sorok száma: " + failedLines.size());
            System.out.println("Hibás sorok sorszáma: " + failedLines);
            run();
        } catch (IOException ioException) {
            System.out.println("Hibás fájlnév vagy elérési út!");
            multiplyRegistration();
        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
        }
        run();
    }

    private void generation() {
        System.out.println("Kérem az irányítószámot: ");
        String postCode = scanner.nextLine();
        try {
            List<Citizen> citizensByPostCode = citizenDao.findCitizensByPostCodeFilteredByVaccination(postCode);
            services.createFile(postCode, citizensByPostCode);
            viewCitizens(citizensByPostCode);
        } catch (IllegalStateException ise) {
            System.out.println("Ezzel az irányítószámmal nem szerepel polgár az adatbázisban!");
        }
        run();
    }

    private void vaccination() {
        String ssnNumber;
        LocalDate date = null;
        String vaccina;
        do {
            System.out.print("Kérem adja meg a TAJ számot: ");
            ssnNumber = scanner.nextLine();
        } while (!citizenDao.isContainSsnNumber(ssnNumber));
        do {
            System.out.print("Kérem adja meg a dátumot (éééé-hh-nn): ");
            try {
                Citizen citizen = citizenDao.findCitizenBySsnNumber(ssnNumber);
                date = services.getDateByString(scanner.nextLine());
                if (citizen.getNumberOfVaccination() == 1 && citizen.getLastVaccination().isAfter(date.minusDays(15))) {
                    System.out.println("Nem oltható! Még nem telt el 15 nap az előző oltást követően!");
                    return;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println("Dátum hibás! Kérem figyeljen a helyes megadásra!");
            }
        } while (date == null);
        do {
            System.out.print("Kérem adja meg az oltóanyag típusát (Pfizer, Moderna, Szputnyik-V, Sinopharm, AstraZeneca): ");
            vaccina = scanner.nextLine();
        } while (!Validation.isValidVaccina(vaccina));
        try {
            vaccinationDao.saveVaccionation(ssnNumber, date, vaccina);
        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
        }
        run();
    }

    private void failedVaccination() {
        String ssnNumber;
        LocalDate date = null;
        String note;

        do {
            System.out.print("Kérem adja meg a TAJ számot: ");
            ssnNumber = scanner.nextLine();
        } while (!citizenDao.isContainSsnNumber(ssnNumber));
        do {
            System.out.print("Kérem adja meg a dátumot (éééé-hh-nn): ");
            try {
                date = services.getDateByString(scanner.nextLine());
            } catch (IllegalArgumentException iae) {
                System.out.println("Dátum hibás! Kérem figyeljen a helyes megadásra!");
            }
        } while (date == null);
        do {
            System.out.print("Kérem írja le a meghiúsulás okát: ");
            note = scanner.nextLine();
        } while (!Validation.isValidNote(note));

        try {
            vaccinationDao.saveFailedVaccionation(ssnNumber, date, note);
        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
        }
        run();
    }

    private void createReport() {
        String postCode = getPostCodeFromConsole();
        List<Citizen> citizens = citizenDao.findCitizensByPostCode(postCode);
        Map<Integer, Integer> report = new TreeMap<>();
        for (Citizen citizen : citizens) {
            int numberOfVaccination = citizen.getNumberOfVaccination();
            if (!report.containsKey(numberOfVaccination)) {
                report.put(numberOfVaccination, 0);
            }
            report.replace(numberOfVaccination, report.get(numberOfVaccination) + 1);
        }
        showReport(new Report(postCode, report));
        run();
    }

    private void showReport(Report report) {
        System.out.println("\nOltások száma");
        System.out.println("-------------");
        System.out.print("Oltás nélküli:\t\t");
        System.out.println(report.getCitizens().getOrDefault(0, 0));
        System.out.print("Egyszer beoltott:\t");
        System.out.println(report.getCitizens().getOrDefault(1, 0));
        System.out.print("Kétszer beoltott:\t");
        System.out.println(report.getCitizens().getOrDefault(2, 0));
    }

    private String getPostCodeFromConsole() {
        String postCode;
        do {
            System.out.print("Kérem adja meg az irányítószámot: ");
            postCode = scanner.nextLine();
        } while (!Validation.isValidZip(postCode));
        return postCode;
    }

    private void invalidParamFromScanner() {
        System.out.println("Biztosan kilép? (I/N)");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("n")) {
            run();
        }
    }

    private void viewCitizens(List<Citizen> citizens) {
        for (Citizen citizen : citizens) {
            System.out.println(citizen);
        }
    }
}
