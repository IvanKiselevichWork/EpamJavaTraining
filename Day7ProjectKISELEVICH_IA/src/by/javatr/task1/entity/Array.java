package by.javatr.task1.entity;

import java.util.Arrays;

public class Array {

    private int[] data;

    /**
     *
     * @param capacity the initial capacity of the array
     *  @throws IllegalArgumentException if the specified capacity is negative
     */
    public Array(int capacity) {
        if (capacity >= 0) {
            data = new int[capacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+ capacity);
        }
    }

    /**
     *
     * @param array the array whose elements are to be placed into this array
     * @throws NullPointerException if the specified array is null
     */
    public Array(int[] array) {
        data = Arrays.copyOf(array, array.length);
    }

    /**
     *
     * @param array the Array object whose elements are to be placed into this array
     * @throws NullPointerException if the specified object is null
     */
    public Array(Array array) {
        data = Arrays.copyOf(array.data, array.data.length);
    }

    /**
     *
     * @param index index of the element to return
     * @return the value at the specified position in this array
     */
    public int get(int index) {
        rangeCheck(index);

        return data[index];
    }

    /**
     *
     * @param index index of the element to replace
     * @param value value to be stored at the specified position
     * @return the value previously at the specified position
     */
    public int set(int index, int value) {
        rangeCheck(index);

        int oldValue = data[index];
        data[index] = value;
        return oldValue;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Illegal index: "+ index);
        }
    }

    /**
     * sort Array data with quick sort algorithm
     */
    public void performQuickSort() {
        quickSort(data, 0, data.length - 1);
    }

    private void quickSort(int[] data, int low, int high) {
        if (low < high) {
            int p = quickSortPartition(data, low, high);
            quickSort(data, low, p - 1);
            quickSort(data, p + 1, high);
        }
    }

    private int quickSortPartition(int[] data, int low, int high) {
        int pivot = data[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (data[j] <= pivot) {
                swap(data, i++, j);
            }
        }
        swap(data, i, high);
        return i;
    }

    private void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    /**
     * sort Array data with bubble sort algorithm
     */
    public void performBubbleSort() {
        bubbleSort(data);
    }

    private void bubbleSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1);
                }
            }
        }
    }

    public void performMergeSort() {
        int[] result = new int[data.length];
        mergeSort(data, 0, data.length - 1);
    }

    private void mergeSort(int[] data, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;

            mergeSort(data, low, middle);
            mergeSort(data, middle + 1, high);

            merge(data, low, middle, high);
        }
    }

    private void merge(int[] data, int low, int middle, int high) {
        int n1 = middle - low + 1;
        int n2 = high - middle;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = data[low + i];
        }

        for (int i = 0; i < n2; i++) {
            right[i] = data[middle + 1 + i];
        }

        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (left[i] < right[j]) {
                data[k++] = left[i++];
            } else {
                data[k++] = right[j++];
            }
        }

        while (i < n1) {
            data[k++] = left[i++];
        }

        while (j < n2) {
            data[k++] = right[j++];
        }
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        for (int i : data) {
            result = result * prime + i;
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Array array = (Array)obj;
        if (data.length != array.data.length) {
            return false;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] != array.data[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(getClass().getSimpleName());
        result.append("{");
        for (int i = 0; i < data.length - 1; i++) {
            result.append(data[i]);
            result.append(", ");
        }
        result.append(data[data.length - 1]);
        result.append("}");
        return result.toString();
    }
}
