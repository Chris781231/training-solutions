package collectionsqueue.jobdispatcher;

public class Job implements Comparable<Job> {

    private final int priority;
    private final String jobDescription;
    private final boolean urgent;

    public Job(int priority, String jobDescription) {
        if (priority < 1 || priority > 10) {
            throw new IllegalArgumentException("Invalid priority");
        }
        if (jobDescription == null || jobDescription.isBlank()) {
            throw new IllegalArgumentException("Invalid jobDescription");
        }
        this.priority = priority;
        this.jobDescription = jobDescription;
        this.urgent = priority < 5;
    }

    public int getPriority() {
        return priority;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public boolean isUrgent() {
        return urgent;
    }

    @Override
    public String toString() {
        return "Job{" +
                "priority=" + priority +
                ", jobDescription='" + jobDescription + '\'' +
                ", urgent=" + urgent +
                '}';
    }

    @Override
    public int compareTo(Job o) {
        return this.priority - o.priority;
    }
}
