package week08.d02.midlevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {

    Random random = new Random(1);
    List<Integer> randomNumbers;

    public List<Integer> getNumbers() {
        randomNumbers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            randomNumbers.add(random.nextInt(90) + 1);
        }

        return randomNumbers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int randomNumber : randomNumbers) {
            sb.append(randomNumber);
        }

        return sb.toString();
    }
}