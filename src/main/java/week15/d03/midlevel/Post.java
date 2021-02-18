package week15.d03.midlevel;

import java.time.LocalDate;

public class Post {

    private String title;
    private LocalDate publishedAt;
    private String content;
    private String owner;

    public Post(String title, LocalDate publishedAt, String content, String owner) {
        this.title = title;
        this.publishedAt = publishedAt;
        this.content = content;
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public String getContent() {
        return content;
    }

    public String getOwner() {
        return owner;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublishedAt(LocalDate publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", publishedAt=" + publishedAt +
                ", content='" + content + '\'' +
                ", owner='" + owner + '\'' +
                "}\n";
    }
}
