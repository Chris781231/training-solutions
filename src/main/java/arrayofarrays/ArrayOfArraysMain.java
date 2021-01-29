package arrayofarrays;

import java.time.Month;

public class ArrayOfArraysMain {

    public static int[][] multiplicationTable(int size) {
        int[][] mpTable = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mpTable[i][j] = (i + 1) * (j + 1);
            }
        }
        return mpTable;
    }

    public static void printArrayOfArrays(int[][] a) {
        for (int[] row: a) {
            for (int item: row) {
                if (item < 10) {
                    System.out.print(item + "  ");
                } else {
                    System.out.print(item + " ");
                }
            }
            System.out.println();
        }
    }

    public static int[][] triangularMatrix(int size) {
        int[][] mpTable = new int[size][];
        for (int i = 0; i < size; i++) {
            mpTable[i] = new int[i+1];
            for (int j = 0; j < mpTable[i].length; j++) {
                mpTable[i][j] = i;
            }
        }
        return mpTable;
    }

    public static int[][] getValues() {
        int[][] daysOfMonth = new int[12][];
        for (int i = 0; i < daysOfMonth.length; i++) {
            daysOfMonth[i] = new int[Month.of(i+1).length(false)];
        }
        return daysOfMonth;
    }


    public static void main(String[] args) {

        int[][] mpTable = ArrayOfArraysMain.multiplicationTable(4);
        ArrayOfArraysMain.printArrayOfArrays(mpTable);

        int[][] triangularTable = ArrayOfArraysMain.triangularMatrix(4);
        ArrayOfArraysMain.printArrayOfArrays(triangularTable);

        int[][] daysOfMonth = ArrayOfArraysMain.getValues();
        printArrayOfArrays(daysOfMonth);

        int[] a = {1, 2, 3};


    }
}
