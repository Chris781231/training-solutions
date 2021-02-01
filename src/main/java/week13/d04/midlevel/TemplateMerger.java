package week13.d04.midlevel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TemplateMerger {

    public static void main(String[] args) {
        TemplateMerger merger = new TemplateMerger();
        Path file = Path.of("employee_template.txt");
        List<Employee> employees = List.of(
                new Employee("John Doe", 1980),
                new Employee("Jack Doe", 1990),
                new Employee("Jane Doe", 1985)
        );
        String mergedEmployees = merger.merge(file, employees);
        System.out.println(mergedEmployees);
    }

    public String merge(Path file, List<Employee> employees) {
        StringBuilder builder = new StringBuilder();
        try {

            Template employeeTemplate = processTemplate(Files.readString(file));

            for (Employee employee : employees) {
                String employeeImage = buildEmployeeByTemplate(employee, employeeTemplate);
                builder.append(employeeImage);
                builder.append("\n");
            }

        } catch (IOException ioException) {
            throw new IllegalStateException("cannot read file");
        }
        return builder.toString();
    }

    private String buildEmployeeByTemplate(Employee employee, Template employeeTemplate) {
        StringBuilder sb = new StringBuilder();
        sb.append(employeeTemplate.getEmptyTemplate(), 0, employeeTemplate.getIndexOfNameStart());
        sb.append(employee.getName());
        sb.append(employeeTemplate.getEmptyTemplate(), employeeTemplate.getIndexOfNameStart(), employeeTemplate.getIndexOfYearOfBirthStart());
        sb.append(employee.getYearOfBirth());
        return sb.toString();
    }

    private Template processTemplate(String templateString) {
        int indexOfNameStart = templateString.indexOf("{");
        int lengthOfName = templateString.substring(indexOfNameStart, templateString.indexOf("}")).length() + 1;
        int indexOfYearOfBirthStart = templateString.indexOf("{", indexOfNameStart + 1);

        StringBuilder employeeTemplate = new StringBuilder();
        employeeTemplate.append(templateString, 0, indexOfNameStart);
        employeeTemplate.append(templateString, indexOfNameStart + lengthOfName, indexOfYearOfBirthStart);
        employeeTemplate.append(" ");

        return new Template(employeeTemplate.toString(), indexOfNameStart, indexOfYearOfBirthStart - lengthOfName);
    }
}
