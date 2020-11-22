package algorithmsmax.trainer;

import java.util.List;

public class MaxAgeCalculator {

    public Trainer trainerWithMaxAge(List<Trainer> trainers) {
        int maxAge = Integer.MIN_VALUE;
        Trainer trainerWithMaxAge = null;

        for (Trainer trainer : trainers) {
            if (trainer.getAge() > maxAge) {
                trainerWithMaxAge = trainer;
                maxAge = trainer.getAge();
            }
        }
        return trainerWithMaxAge;
    }
}
