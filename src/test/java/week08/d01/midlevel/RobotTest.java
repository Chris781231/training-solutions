package week08.d01.midlevel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RobotTest {

    Robot robot = new Robot();

    @Test
    void robotMoveTest() {
        assertEquals("Point{x=3, y=-3}", robot.move("FFLLLLLBBBBJJJJJJJ").toString());
    }

    @Test
    void falseStringAcceptedAsParameter() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> robot.move("FFLLLLLBBBBaJJJJJJJ"));
        assertEquals("invalid parameter: 'a' character at 11. index", e.getMessage());
    }
}
