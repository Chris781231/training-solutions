package debug.employees;

import java.util.ArrayList;
import java.util.List;

public class CompanyMain {

    public static void main(String[] args) {

        Employee cParker = new Employee("Charlie Parker", 1978);
        Employee rMartinkovic = new Employee("Reggi Martinkovic", 1997);
        Employee lParker = new Employee("Lucy Parker", 2018);

        List<Employee> employees = new ArrayList<>();
        employees.add(cParker);
        employees.add(rMartinkovic);
        employees.add(lParker);

        Company cParkerInc = new Company(employees);

        Employee charlieParker = cParkerInc.findEmployeeByName("Charlie Parker");
        System.out.println(charlieParker.getName() + " (" + charlieParker.getYearOfBirth() + ")");

        System.out.println(cParkerInc.listEmployeeNames());
    }
}
