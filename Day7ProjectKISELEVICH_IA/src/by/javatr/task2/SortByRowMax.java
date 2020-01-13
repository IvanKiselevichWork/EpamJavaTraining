package by.javatr.task2;

public class SortByRowMax implements SortParameter {
    @Override
    public int getSortParameter(int[] row) {
        int max = Integer.MIN_VALUE;
        for (int n : row) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }
}
