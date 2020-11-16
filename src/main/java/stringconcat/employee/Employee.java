package stringconcat.employee;

public class Employee {

    private String name;
    private String job;
    private int salary;

    public Employee(String name, String job, int salary) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name must not be empty.");
        } else {
            this.name = name;
        }

        if (job == null || job.equals("")) {
            throw new IllegalArgumentException("Job must not be empty.");
        } else {
            this.job = job;
        }

        if (salary % 1000 != 0 || salary <= 0) {
            throw new IllegalArgumentException("Salary must be positive.");
        } else {
            this.salary = salary;
        }
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "%s - %s - %d Ft".formatted(getName(), getJob(), getSalary());
    }
}
