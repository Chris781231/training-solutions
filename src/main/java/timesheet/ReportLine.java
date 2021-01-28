package timesheet;

public class ReportLine {
    private final Project project;
    private long time;

    public ReportLine(Project project, long time) {
        this.project = project;
        this.time = time;
    }

    public Project getProject() {
        return project;
    }

    public long getTime() {
        return time;
    }

    public void addTime(long time) {
        this.time += time;
    }

    @Override
    public String toString() {
        return String.format("%s\t%d\n", project, time);
    }
}
