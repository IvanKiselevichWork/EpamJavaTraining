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
