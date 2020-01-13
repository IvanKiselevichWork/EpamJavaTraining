package by.javatr.task2;

public class JaggedArray {

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

        sortRowsBySortParameter(array, new SortByRowSum());

        System.out.println("Sorted by row sum array:");
        printJaggedArray(array);

        sortRowsBySortParameter(array, new SortByRowMax());

        System.out.println("Sorted by row max array:");
        printJaggedArray(array);

        sortRowsBySortParameter(array, new SortByRowMin());

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

    /**
     *
     * @param array would be sorted
     */
    public static void sortRowsBySortParameter(int[][] array, SortParameter sortParameter) {
        for (int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                //todo
                if (sortParameter.getSortParameter(array[j]) > sortParameter.getSortParameter(array[j + 1])) {
                    swapRows(array, j, j + 1);
                }
            }
        }
    }

    private static void swapRows(int[][] array, int row1, int row2) {
        int[] temp = array[row1];
        array[row1] = array[row2];
        array[row2] = temp;
    }

}
