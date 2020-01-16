package by.javatr.task1.entity;


import by.javatr.task1.entity.exception.*;
import by.javatr.task1.entity.exception.IndexOutOfBoundsException;

public class Array {

    private int[] data;

    private boolean isSorted = false;

    private static final int DEFAULT_CAPACITY = 10;

    /**
     * create Array with default capacity (10)
     */
    public Array() {
        data = new int[DEFAULT_CAPACITY];
    }

    /**
     *
     * @param capacity the initial capacity of the array
     * @throws NegativeCapacityException if the specified capacity is negative
     */
    public Array(int capacity) throws NegativeCapacityException {
        if (capacity < 0) {
            throw new NegativeCapacityException("Illegal Capacity: "+ capacity);
        }
        data = new int[capacity];
    }

    /**
     *
     * @param array the array whose elements are to be placed into this Array
     * @throws ArrayIsNullException if the specified array is null
     */
    public Array(int[] array) throws ArrayIsNullException {
        if (array == null) {
            throw new ArrayIsNullException("array is null");
        }
        data = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            data[i] = array[i];
        }
    }

    /**
     * create Array from specified array values with specified length
     * @param array the array whose elements are to be placed into this Array
     * @param newLength Array length
     * @throws ArrayIsNullException if the specified array is null
     * @throws NegativeLengthException if newLength is negative
     */
    public Array(int[] array, int newLength) throws ArrayIsNullException, NegativeLengthException {
        if (array == null) {
            throw new ArrayIsNullException("array is null");
        }
        if (newLength < 0) {
            throw new NegativeLengthException("newLength is negative: " + newLength);
        }
        data = new int[newLength];
        for (int i = 0; i < newLength || i < array.length; i++) {
            data[i] = array[i];
        }

    }

    /**
     *
     * @param array the Array object whose elements are to be placed into this array
     * @throws ArrayIsNullException if the specified array is null
     */
    public Array(Array array) throws ArrayIsNullException {
        if (array == null) {
            throw new ArrayIsNullException("Array is null");
        }
        data = new int[array.data.length];
        for (int i = 0; i < array.data.length; i++) {
            data[i] = array.data[i];
        }
    }

    /**
     *
     * @param index index of the element to return
     * @return the value at the specified position in this array
     * @throws NegativeIndexException if index is negative
     * @throws IndexOutOfBoundsException if index out of bounds
     */
    public int get(int index) throws IndexOutOfBoundsException, NegativeIndexException {
        rangeCheck(index);

        return data[index];
    }

    /**
     *
     * @param index index of the element to replace
     * @param value value to be stored at the specified position
     * @return the value previously at the specified position
     * @throws NegativeIndexException if index is negative
     * @throws IndexOutOfBoundsException if index out of bounds
     */
    public int set(int index, int value) throws IndexOutOfBoundsException, NegativeIndexException  {
        rangeCheck(index);

        int oldValue = data[index];
        data[index] = value;

        if (oldValue != value) {
            isSorted = false;
        }
        return oldValue;
    }

    private void rangeCheck(int index) throws IndexOutOfBoundsException, NegativeIndexException {
        if (index < 0) {
            throw new NegativeIndexException("Index is negative: " + index);
        }
        if (index >= data.length) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    /**
     * sort Array data with quick sort algorithm
     */
    public void performQuickSort() {
        quickSort(0, data.length - 1);
        isSorted = true;
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int p = quickSortPartition(low, high);
            quickSort(low, p - 1);
            quickSort(p + 1, high);
        }
    }

    private int quickSortPartition(int low, int high) {
        int pivot = data[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (data[j] <= pivot) {
                swap(i++, j);
            }
        }
        swap(i, high);
        return i;
    }

    private void swap(int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    /**
     * sort Array data with bubble sort algorithm
     */
    public void performBubbleSort() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
        isSorted = true;
    }

    /**
     * sort Array data with merge sort algorithm
     */
    public void performMergeSort() {
        mergeSort(0, data.length - 1);
    }

    private void mergeSort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;

            mergeSort(low, middle);
            mergeSort(middle + 1, high);

            merge(low, middle, high);
        }
        isSorted = true;
    }

    private void merge(int low, int middle, int high) {
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

    /**
     * sort data with quick sort and search value index with binary algorithm
     * @param value element to be searched
     * @return index of first occurrence of the specified element or -1 if there is no such index
     */
    public int findValueIndexWithBinarySearch(int value) throws ArrayNotSortedException {
        if (!isSorted) {
            throw new ArrayNotSortedException("Cant perform binary search in unsorted array");
        }
        return getIndexWithBinarySearch(value, 0, data.length - 1);
    }

    private int getIndexWithBinarySearch(int value, int low, int high) {
        if (low <= high) {
            int middle = low + (high - low) / 2;
            if (value == data[middle]) {
                return middle;
            }
            
            if (data[middle] < value) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
            return getIndexWithBinarySearch(value, low, high);

        }
        return -1;
    }

    /**
     *
     * @return size of Array
     */
    public int size() {
        return data.length;
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
