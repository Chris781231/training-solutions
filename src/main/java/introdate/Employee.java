package introdate;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee {

    private String name;
    private LocalDate birthOfDate;
    private LocalDateTime beginEmployment;

    public Employee(String name, LocalDate birthOfDate) {
        this.name = name;
        this.birthOfDate = birthOfDate;
        this.beginEmployment = LocalDateTime.now();
    }

    public LocalDate getDateOfBirth() {
        return this.birthOfDate;
    }

    public String getName() {
        return this.name;
    }

    public LocalDateTime getBeginEmployment() {
        return this.beginEmployment;
    }

    public void setName(String name) {
        this.name = name;
    }
}
