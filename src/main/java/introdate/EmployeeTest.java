package introdate;

import java.time.LocalDate;
import java.util.Scanner;

public class EmployeeTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Employee app\n");
        System.out.print("Employee name: ");
        String name = scanner.nextLine();
        System.out.print("Year of birth: ");
        int yearOfBirth = scanner.nextInt();
        System.out.print("Month of birth: ");
        int monthOfBirth = scanner.nextInt();
        System.out.print("Day of birth: ");
        int dayOfBirth = scanner.nextInt();
        LocalDate dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);

        Employee employee = new Employee(name, dateOfBirth);
        System.out.println("Name: " + employee.getName());
        System.out.println("Date of birth: " + employee.getDateOfBirth());
        System.out.println("Begin employment: " + employee.getBeginEmployment());
    }
}
