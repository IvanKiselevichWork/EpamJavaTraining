package by.javatr.task2.service;

import by.javatr.task2.service.helper.SortHelper;
import by.javatr.task2.service.exception.ArrayIsNullRuntimeException;
import by.javatr.task2.service.exception.SortHelperIsNullRuntimeException;

public class JaggedArrayService {

    /**
     *
     * @param array would be sorted
     * @throws ArrayIsNullRuntimeException if array is null
     * @throws SortHelperIsNullRuntimeException if sortHelper is null
     */
    public void sortRowsBySortParameter(int[][] array, SortHelper sortHelper) throws ArrayIsNullRuntimeException, SortHelperIsNullRuntimeException {
        if (array == null) {
            throw new ArrayIsNullRuntimeException("array is null");
        }
        if (sortHelper == null) {
            throw new SortHelperIsNullRuntimeException("sortHelper is null");
        }
        for (int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                if (sortHelper.isSwapNeeded(array[j], array[j + 1])) {
                    swapRows(array, j, j + 1);
                }
            }
        }
    }

    private void swapRows(int[][] array, int row1, int row2) {
        int[] temp = array[row1];
        array[row1] = array[row2];
        array[row2] = temp;
    }

}
