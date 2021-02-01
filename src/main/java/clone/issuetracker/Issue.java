package clone.issuetracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Issue {

    private String name;
    private LocalDateTime time;
    private Status status;
    private List<Comment> comments = new ArrayList<>();

    public Issue(String name, LocalDateTime time, Status status) {
        this.name = name;
        this.time = time;
        this.status = status;
    }

    public Issue(Issue another, CopyMode copyMode) {
        this.name = another.name;
        this.time = another.time;
        this.status = another.status;

        if (copyMode.equals(CopyMode.WITH_COMMENTS)) {
            List<Comment> temp = new ArrayList<>();
            for (Comment comment : another.comments) {
                temp.add(new Comment(comment));
            }
            this.comments = temp;
        }
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Status getStatus() {
        return status;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
