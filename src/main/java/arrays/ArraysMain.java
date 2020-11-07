package arrays;

import arraysofarrays.ArraysOfArraysMain;

import java.util.Arrays;
import java.util.List;

public class ArraysMain {

    public static String numberOfDaysAsString() {
        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        return Arrays.toString(numberOfDays);
    }

    public static List<String> daysOfWeek() {
        String[] daysOfWeek = {"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap"};
        return Arrays.asList(daysOfWeek);
    }

    public static String multiplicationTableAsString(int size) {
        int[][] mpTable = ArraysOfArraysMain.multiplicationTable(size);

        return Arrays.deepToString(mpTable);
    }

    public static boolean sameTempValues(double[] day, double[] anotherDay) {
        return Arrays.equals(day, anotherDay);
    }

    public static boolean wonLottery(int[] drawn, int[] taken) {
        int[] drawnParam = Arrays.copyOf(drawn, drawn.length);
        int[] takenParam = Arrays.copyOf(taken, taken.length);
        Arrays.sort(drawnParam);
        Arrays.sort(takenParam);
        return Arrays.equals(drawnParam, takenParam);
    }

    public static boolean sameTempValuesDaylight(double[] day, double[] anotherDay) {
        int min = Math.min(day.length, anotherDay.length);
        double[] dayCopyOfRange = Arrays.copyOfRange(day, 0, min);
        double[] anotherDayCopyOfRange = Arrays.copyOfRange(anotherDay, 0, min);

        return Arrays.equals(dayCopyOfRange, anotherDayCopyOfRange);
    }


    public static void main(String[] args) {

        System.out.println(numberOfDaysAsString());

        System.out.println(daysOfWeek());

        System.out.println(multiplicationTableAsString(4));

        double[] day1 = {12.4, 13.5, 4.1, 5.3, 12.4, 13.5, 4.1, 5.3, 12.4, 13.5, 4.1, 5.3, 12.4, 13.5, 4.1, 5.3, 12.4, 13.5, 4.1, 5.3, 12.4, 13.5, 4.1, 5.3};
        double[] day2 = {12.4, 13.5, 4.1, 5.3, 12.4, 13.5, 4.1, 5.3, 12.4, 13.5, 4.1, 5.3, 12.4, 13.5, 4.1, 5.3, 12.4, 13.5, 4.1, 5.3, 12.4, 13.5, 4.1, 5.3};
        System.out.println(sameTempValues(day1, day2));

        int[] drawn = {5, 8, 75, 13, 47};
        int[] taken = {5, 75, 13, 47, 8};
        System.out.println(wonLottery(drawn, taken));
        System.out.println(Arrays.toString(drawn));
        System.out.println(Arrays.toString(taken));

        double[] day3 = {12.4, 13.5, 4.1, 5.3, 12.4, 13.5, 4.1, 5.3, 12.4, 13.5, 4.1, 5.3, 12.4, 13.5, 4.1, 5.3, 12.4, 13.5, 4.1, 5.3, 12.4, 13.5, 4.1};
        double[] day4 = {12.4, 13.5, 4.1, 5.3, 12.4, 13.5, 4.1, 5.3, 12.4, 13.5, 4.1, 5.3, 12.4, 13.5, 4.1, 5.3, 12.4, 13.5, 4.1, 5.3, 12.4, 13.5, 4.1, 5.3, 4.2};
        System.out.println(sameTempValuesDaylight(day3, day4));
    }
}
