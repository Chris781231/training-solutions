package intromethods;

public class EmployeeMain {

    public static void main(String[] args) {

        Employee employee = new Employee("Charlie Parker", 2016, 250000);

        System.out.println(employee.getName() + "\n" + employee.getHiringYear() + "\n" + employee.getSalary());
        employee.setName("Charles Parker");
        employee.raiseSalary(25000);
        System.out.println(employee);
    }
}
