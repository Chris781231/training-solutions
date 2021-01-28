package timesheet;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Company {

    List<Project> projects = new ArrayList<>();
    List<Employee> employees = new ArrayList<>();
    List<TimeSheetItem> timeSheetItems = new ArrayList<>();

    public Company(InputStream employeeFile, InputStream projectFile) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(employeeFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(" ");
                employees.add(new Employee(temp[0], temp[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("cannot read file", ioe);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(projectFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                projects.add(new Project(line));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("cannot read file", ioe);
        }
    }

    public void addTimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        timeSheetItems.add(new TimeSheetItem(employee, project, beginDate, endDate));
    }

    public List<ReportLine> calculateProjectByNameYearMonth(String employeeName, int year, int month) {
        if (!isValidEmployeeName(employeeName)) {
            throw new IllegalArgumentException("wrong name");
        }
        List<ReportLine> reportLines = createReportLines();
        for (TimeSheetItem timeSheetItem : timeSheetItems) {
            if (timeSheetItem.getEmployee().getName().equals(employeeName) &&
                    timeSheetItem.getBeginDate().getYear() == year &&
                    timeSheetItem.getBeginDate().getMonthValue() == month) {
                addTimeToActualReportLine(reportLines, timeSheetItem);

            }
        }
        return reportLines;
    }

    private boolean isValidEmployeeName(String employeeName) {
        for (Employee employee : employees) {
            if (employee.getName().equals(employeeName)) {
                return true;
            }
        }
        return false;
    }

    private void addTimeToActualReportLine(List<ReportLine> reportLines, TimeSheetItem timeSheetItem) {
        for (ReportLine reportLine : reportLines) {
            if (timeSheetItem.getProject().getName().equals(reportLine.getProject().getName())) {
                reportLine.addTime(timeSheetItem.hoursBetweenDates());
            }
        }
    }

    private List<ReportLine> createReportLines() {
        List<ReportLine> reportLines = new ArrayList<>();
        for (Project project : projects) {
            reportLines.add(new ReportLine(project, 0));
        }
        return reportLines;
    }

    public void printToFile(String employeeName, int year, int month, Path file) {
        List<ReportLine> reportLines = calculateProjectByNameYearMonth(employeeName, year, month);
        long sumOfHours = calcSumOfHours(reportLines);

        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file, StandardCharsets.UTF_8))) {
            writer.print(String.format("%s\t%d-%02d\t%d\n", employeeName, year, month, sumOfHours));
            for (ReportLine reportLine : calculateProjectByNameYearMonth(employeeName, year, month)) {
                if (reportLine.getTime() != 0) {
                    writer.print(reportLine);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("cannot write file", ioe);
        }
    }

    private long calcSumOfHours(List<ReportLine> reportLines) {
        long sum = 0;
        for (ReportLine reportLine : reportLines) {
            sum += reportLine.getTime();
        }
        return sum;
    }

    public List<Project> getProjects() {
        return new ArrayList<>(projects);
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public List<TimeSheetItem> getTimeSheetItems() {
        return new ArrayList<>(timeSheetItems);
    }
}
