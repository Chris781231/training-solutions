package week10.d02.midlevel;

import java.util.List;

public class MaxTravel {

    public static final int COUNT_OF_STOPS = 30;

    public int getMaxIndex(List<Integer> boardingPeople) {
        int[] boardingPeopleByStops = new int[COUNT_OF_STOPS];

        for (int people : boardingPeople) {
            boardingPeopleByStops[people]++;
        }

        return findMaxBoardingPeople(boardingPeopleByStops);
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
