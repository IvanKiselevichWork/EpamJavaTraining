package by.javatr.task2.runner;

import by.javatr.task2.helper.SortByRowMax;
import by.javatr.task2.helper.SortByRowMin;
import by.javatr.task2.helper.SortByRowSum;
import by.javatr.task2.service.JaggedArrayService;

public class Main {

    private static final int ROW_COUNT = 10;

    public static void main(String[] args) {
        int[][] array = new int[ROW_COUNT][];

        for (int i = 0; i < ROW_COUNT; i++) {
            array[i] = new int[(int)(Math.random() * 10 + 1)];
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int)(Math.random() * 100);
            }
        }

        System.out.println("Source array:");
        printJaggedArray(array);

        JaggedArrayService jaggedArrayService = new JaggedArrayService();

        jaggedArrayService.sortRowsBySortParameter(array, new SortByRowSum());

        System.out.println("Sorted by row sum array:");
        printJaggedArray(array);

        jaggedArrayService.sortRowsBySortParameter(array, new SortByRowMax());

        System.out.println("Sorted by row max array:");
        printJaggedArray(array);

        jaggedArrayService.sortRowsBySortParameter(array, new SortByRowMin());

        System.out.println("Sorted by row min array:");
        printJaggedArray(array);

    }

    private static void printJaggedArray(int[][] array) {
        for (int[] row : array) {
            System.out.print("[ ");
            for(int n : row) {
                System.out.print(n + " ");
            }
            System.out.println("]");
        }
    }

}
