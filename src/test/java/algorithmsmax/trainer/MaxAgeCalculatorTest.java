package algorithmsmax.trainer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxAgeCalculatorTest {

    List<Trainer> trainers = List.of(
            new Trainer("Józsibá", 65),
            new Trainer("Ági néni", 42),
            new Trainer("Trainer János", 34)
    );

    @Test
    void maxAgeCalculatorTest() {
        assertEquals(trainers.get(0).getName(), new MaxAgeCalculator().trainerWithMaxAge(trainers).getName());
    }
}
