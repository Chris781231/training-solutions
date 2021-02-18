package week15.d03.midlevel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostFinder {

    List<Post> posts;

    public PostFinder(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> findPostsFor(String user) {
        List<Post> result = new ArrayList<>();

        for (Post post : posts) {
            if (post.getOwner().equals(user) &&
                    !isEmpty(post.getTitle()) &&
                    !isEmpty(post.getContent()) &&
                    post.getPublishedAt().isBefore(LocalDate.now())) {
                result.add(post);
            }
        }

        return result;
    }

    private boolean isEmpty(String param) {
        return param == null || param.isBlank();
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public List<Post> getPosts() {
        return new ArrayList<>(posts);
    }
}
