package week12.d01.midlevel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class GradeRounderTest {

    @Test
    void roundGrades() {
        GradeRounder gradeRounder = new GradeRounder();
        assertArrayEquals(new int[]{1, 2, 5, 39, 41, 42, 45, 45, 45, 46, 47, 50, 50, 50},
                gradeRounder.roundGrades(new int[]{1, 2, 5, 39, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50}));

    }
}