package week15.d03.midlevel;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostFinderTest {

    List<Post> posts = new ArrayList<>(List.of(
            new Post("1. post", LocalDate.of(2020, 11, 21), "blablablablablabalbalblablablablablab", "Chris"),
            new Post("2. post", LocalDate.of(2020, 9, 18), "blablablablablabalbalblablablablablab", "Reggie"),
            new Post("3. post", LocalDate.of(2020, 6, 9), "blablablablablabalbalblablablablablab", "Luca"),
            new Post("4. post", LocalDate.of(2020, 5, 5), "", "Chris"),
            new Post("5. post", LocalDate.of(2020, 12, 30), "blablablablablabalbalblablablablablab", "Chris"),
            new Post(null, LocalDate.of(2020, 12, 30), null, "Chris"),
            new Post("6. post", LocalDate.of(2021, 12, 31), "blablablablablabalbalblablablablablab", "Chris")
    ));
    PostFinder finder = new PostFinder(posts);

    @Test
    void findPostsFor() {
        List<Post> expected = new ArrayList<>(List.of(
                new Post("1. post", LocalDate.of(2020, 11, 21), "blablablablablabalbalblablablablablab", "Chris"),
                new Post("5. post", LocalDate.of(2020, 12, 30), "blablablablablabalbalblablablablablab", "Chris")
        ));
        assertEquals(expected.toString(), finder.findPostsFor("Chris").toString());
    }
}