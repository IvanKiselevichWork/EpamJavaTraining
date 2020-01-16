package by.javatr.task2.service.helper;

public class SortByRowMin implements SortHelper {
    @Override
    public boolean isSwapNeeded(int[] row1, int[] row2) {
        if (row1 == null || row1.length == 0) {
            return false;
        }
        if (row2 == null || row2.length == 0) {
            return true;
        }

        int min1 = row1[0];
        for (int n : row1) {
            if (n < min1) {
                min1 = n;
            }
        }

        int min2 = row2[0];
        for (int n : row2) {
            if (n < min2) {
                min2 = n;
            }
        }

        return min1 > min2;
    }
}
