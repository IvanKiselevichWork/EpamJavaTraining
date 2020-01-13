package by.javatr.task2;

public class SortByRowSum implements SortParameter {
    @Override
    public int getSortParameter(int[] row) {
        int sum = 0;
        for (int n : row) {
            sum += n;
        }
        return sum;
    }
}
