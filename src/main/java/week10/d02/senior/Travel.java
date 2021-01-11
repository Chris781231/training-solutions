package week10.d02.senior;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Travel {

    public static final int COUNT_OF_STOPS = 30;

    public int getStopWithMax(InputStream in) {
        List<Integer> boardingPeople = loadFromFile(in);
        int[] boardingPeopleByStops = new int[COUNT_OF_STOPS];

        for (int people : boardingPeople) {
            boardingPeopleByStops[people]++;
        }

        return findMaxBoardingPeople(boardingPeopleByStops);
    }

    private List<Integer> loadFromFile(InputStream in) {
        List<Integer> boardingPeople = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                boardingPeople.add(Integer.parseInt(parts[0]));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }

        return boardingPeople;
    }

    private int findMaxBoardingPeople(int[] boardingPeopleByStops) {
        int max = Integer.MIN_VALUE;

        for (int temp : boardingPeopleByStops) {
            if (temp > max) {
                max = temp;
            }
        }

        return max;
    }
}
