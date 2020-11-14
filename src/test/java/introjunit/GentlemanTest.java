package introjunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GentlemanTest {

    @Test
    public void testSayHello() {

        // Given
        Gentleman gentleman = new Gentleman();

        // When
        String result = gentleman.sayHello("Charlie");

        // Then
        assertEquals("Hello, Charlie", result);
    }

    @Test
    public void testSayHelloNull() {

        assertEquals("Hello, Anonymous", new Gentleman().sayHello());
    }
}
