package week13.d03.midlevel;

public class Assignment {

    private final String name;
    private final String subject;
    private final String className;
    private final int weeklyAmount;

    public Assignment(String name, String subject, String department, int weeklyAmount) {
        this.name = name;
        this.subject = subject;
        this.className = department;
        this.weeklyAmount = weeklyAmount;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getClassName() {
        return className;
    }

    public int getWeeklyAmount() {
        return weeklyAmount;
    }
}
