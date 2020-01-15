package by.javatr.task2.helper;

public class SortByRowSum implements SortHelper {
    @Override
    public boolean isSwapNeeded(int[] row1, int[] row2) {
        if (row1 == null || row1.length == 0) {
            return false;
        }
        if (row2 == null || row2.length == 0) {
            return true;
        }

        int sum1 = 0;
        for (int n : row1) {
            sum1 += n;
        }

        int sum2 = 0;
        for (int n : row2) {
            sum2 += n;
        }

        return sum1 > sum2;
    }
}
