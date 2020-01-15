package by.javatr.task2.helper;

public class SortByRowMax implements SortHelper {
    @Override
    public boolean isSwapNeeded(int[] row1, int[] row2) {
        if (row1 == null || row1.length == 0) {
            return false;
        }
        if (row2 == null || row2.length == 0) {
            return true;
        }

        int max1 = row1[0];
        for (int n : row1) {
            if (n > max1) {
                max1 = n;
            }
        }

        int max2 = row2[0];
        for (int n : row2) {
            if (n > max2) {
                max2 = n;
            }
        }

        return max1 > max2;
    }
}
