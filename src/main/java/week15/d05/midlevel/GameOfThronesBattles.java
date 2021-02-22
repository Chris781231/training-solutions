package week15.d05.midlevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GameOfThronesBattles {

    private final Map<String, Integer> battles = new HashMap<>();

    public static void main(String[] args) {

        GameOfThronesBattles gotBattles = new GameOfThronesBattles();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                GameOfThronesBattles.class.getResourceAsStream("battles.csv")))) {
            gotBattles.readFromFile(reader);
            String mostBattleOfHouse = gotBattles.getMostBattleOfHouse();
            System.out.println(mostBattleOfHouse);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot find file", ioe);
        }
    }

    private void readFromFile(BufferedReader reader) {
        try {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private void processLine(String line) {
        String[] temp = line.split(",");
        // temp[5] - temp[12]
        for (int i = 5; i <= 12; i++) {
            if (!temp[i].equals("")) {
                addBattle(temp, i);
            }
        }
    }

    private void addBattle(String[] temp, int i) {
        if (!battles.containsKey(temp[i])) {
            battles.put(temp[i], 0);
        }
        battles.put(temp[i], battles.get(temp[i]) + 1);
    }

    public String getMostBattleOfHouse() {
        String mostBattleOfHouse = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> battle : battles.entrySet()) {
            if (battle.getValue() > maxCount) {
                mostBattleOfHouse = battle.getKey();
                maxCount = battle.getValue();
            }
        }

        return mostBattleOfHouse;
    }
}
