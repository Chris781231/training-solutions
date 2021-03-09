package covid.service;

import covid.Citizen;
import covid.dao.CitizenDao;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Services {

    private MariaDbDataSource dataSource;

    public Services(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    /*public static void main(String[] args) {
        System.out.println(new Services(new MariaDbDataSource()).validateTaj(new Citizen("John Doe", "2600", 42, "a@b.cd", "123456788")));
    }

    public boolean validateTaj(Citizen citizen) {
        int sum = 0;
        for(int i =1; i <= 8; i++) {
            int cursor = citizen.getSsnNumber().charAt(i - 1) - '0';
            if(i  % 2 == 0) {
                int actual = cursor * 7;
                System.out.println("position:" +i);
                System.out.println(actual);
                sum+= actual;
            } else {
                int actual = cursor * 3;
                System.out.println("position: " + i);
                System.out.println(actual);
                sum+= actual;
            }
        }
        System.out.println(sum);
        int lastDigit = citizen.getSsnNumber().charAt(8) - '0';
        System.out.println(lastDigit);
        return sum % 10 == lastDigit;
    }*/

    public List<Integer> readFromFile(BufferedReader reader) throws IllegalStateException {
        List<Integer> failedLines = new ArrayList<>();
        int lineCount = 1;
        String line;
        try {
            reader.readLine();
            lineCount++;
            while ((line = reader.readLine()) != null) {
                boolean success = processLine(line);
                if (!success) {
                    failedLines.add(lineCount);
                }
                lineCount++;
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Fájl beolvasása sikertelen!", ioe);
        }
        return failedLines;
    }

    public void createFile(String partOfFileName, List<Citizen> citizens) throws IllegalStateException {
        List<String> createdCitizenList = createListForFile(citizens);
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Path.of(partOfFileName + ".csv"), StandardCharsets.UTF_8, StandardOpenOption.CREATE))) {
            writer.println("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám");
            for (String s : createdCitizenList) {
                writer.println(s);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Fájl írása sikertelen!", ioe);
        }
    }

    public LocalDate getDateByString(String dateString) throws IllegalArgumentException {
        if (!Validation.isValidDateFormat(dateString)) {
            throw new IllegalArgumentException("Dátum formátum hibás!");
        }

        String[] parts = dateString.split("-");
        LocalDate date = LocalDate.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));

        if (date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Dátum nem lehet későbbi, mint az aktuális dátum!");
        }

        return date;
    }

    private boolean processLine(String line) {
        String[] temp = line.split(";");
        if (Validation.isValidName(temp[0]) &&
                Validation.isValidZip(temp[1]) &&
                Validation.isValidAge(Integer.parseInt(temp[2])) &&
                Validation.isValidEmail(temp[3]) &&
                Validation.isValidSsnNumber(temp[4])
        ) {
            Citizen citizen = new Citizen(temp[0], temp[1], Integer.parseInt(temp[2]), temp[3], temp[4]);
            new CitizenDao(dataSource).saveCitizen(citizen);
            return true;
        }
        return false;
    }

    private List<String> createListForFile(List<Citizen> citizens) {
        List<String> result = new ArrayList<>();
        LocalTime time = LocalTime.of(8, 00);

        for (Citizen citizen : citizens) {
            StringBuilder sb = new StringBuilder();
            sb.append(time).append(";");
            sb.append(citizen.getName()).append(";");
            sb.append(citizen.getAge()).append(";");
            sb.append(citizen.getEmail()).append(";");
            sb.append(citizen.getSsnNumber());
            result.add(sb.toString());
            time = time.plusMinutes(30);
        }

        return result;
    }
}
