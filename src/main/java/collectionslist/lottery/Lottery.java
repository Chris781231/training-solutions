package collectionslist.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lottery {

    private final Random rnd = new Random();

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (ballCount <= lotteryType) {
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }
        List<Integer> winningNumbers = new ArrayList<>();

        while (winningNumbers.size() < lotteryType) {
            int winningNumber = rnd.nextInt(ballCount) + 1;
            if (!winningNumbers.contains(winningNumber)) {
                winningNumbers.add(winningNumber);
            }
        }

        Collections.sort(winningNumbers);

        return winningNumbers;
    }
}
