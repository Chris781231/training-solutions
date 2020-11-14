import introjunit.Gentleman;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GentlemanTest {

    @Test
    public void testSayHello() {

        // Given
        Gentleman gentleman = new Gentleman();

        // When
        String result = gentleman.sayHello("Charlie");

        // Then
        assertThat(result, equalTo("Hello, Charlie"));
    }

    @Test
    public void testSayHelloNull() {

        assertThat(new Gentleman().sayHello(), equalTo("Hello, Anonymous"));
    }
}
