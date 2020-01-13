package by.javatr.task2;

public class SortByRowMin implements SortParameter {
    @Override
    public int getSortParameter(int[] row) {
        int min = Integer.MAX_VALUE;
        for (int n : row) {
            if (n < min) {
                min = n;
            }
        }
        return min;
    }
}
