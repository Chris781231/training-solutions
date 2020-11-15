package controlselection.greetings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GreetingsTest {

    @Test
    public void testGreet() {
        Greetings greetings = new Greetings();
        Assertions.assertEquals("jó éjt", greetings.greet(4, 30));
        Assertions.assertEquals("jó éjt", greetings.greet(5, 0));
        Assertions.assertEquals("jó reggelt", greetings.greet(5, 1));
        Assertions.assertEquals("jó reggelt", greetings.greet(9, 0));
        Assertions.assertEquals("jó napot", greetings.greet(9, 1));
        Assertions.assertEquals("jó napot", greetings.greet(18, 30));
        Assertions.assertEquals("jó estét", greetings.greet(18, 31));
        Assertions.assertEquals("jó estét", greetings.greet(20, 00));
        Assertions.assertEquals("jó éjt", greetings.greet(20, 01));
    }
}
