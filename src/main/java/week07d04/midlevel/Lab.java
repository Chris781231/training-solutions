package week07d04.midlevel;

import java.time.LocalDateTime;

public class Lab {

    private final String title;
    private boolean completed;
    private LocalDateTime completedAt;

    public Lab(String title) {
        this.title = title;
    }

    public Lab(String title, LocalDateTime completedAt) {
        this.title = title;
        this.completed = true;
        this.completedAt = completedAt;
    }

    public void complete(LocalDateTime completedAt) {
        if (!completed) {
            completed = true;
            this.completedAt = completedAt;
        } else {
            throw new IllegalArgumentException("This lab is already completed at " + this.completedAt + "!");
        }
    }

    public void complete() {
        complete(LocalDateTime.now());
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "title='" + title + '\'' +
                ", completed=" + completed +
                ", completedAt=" + completedAt +
                '}';
    }
}
