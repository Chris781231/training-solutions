package week12.d03.senior;

import java.util.Arrays;

public class AgeSorter {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new AgeSorter().sortAges(new int[]{1, 4, 6, 34, 52, 16, 63, 100, 54, 6, 2})));
    }

    public int[] sortAges(int[] ages) {
        int[] countedAges = new int[130];
        for (int age : ages) {
            countedAges[age] += 1;
        }

        int[] result = new int[ages.length];

        int index = 0;
        for (int num = 0; num < countedAges.length; num++) {
            int numCount = countedAges[num];
            if (numCount > 0) {
                for (int i = 0; i < numCount; i++) {
                    result[index] = num;
                    index++;
                }
            }
        }

        return result;
    }
}
