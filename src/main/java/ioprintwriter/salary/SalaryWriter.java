package ioprintwriter.salary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SalaryWriter {

    private final List<String> names;

    public SalaryWriter(List<String> names) {
        if (names == null) {
            throw new IllegalArgumentException("names is null");
        }
        this.names = names;
    }

    public void writeNamesAndSalaries(Path file) {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))) {
            int salary;
            for (String name : names) {
                if (name.startsWith("Dr")) {
                    salary = 500_000;
                } else if (name.startsWith("Mr") || name.startsWith("Mrs")) {
                    salary = 200_000;
                } else {
                    salary = 100_000;
                }
                writer.print(name);
                writer.print(": ");
                writer.println(salary);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file");
        }
    }
}
