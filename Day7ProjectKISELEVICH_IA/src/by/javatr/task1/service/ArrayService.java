package by.javatr.task1.service;

import by.javatr.task1.entity.Array;
import by.javatr.task1.service.exception.ArrayIsNullRuntimeException;
import by.javatr.task1.service.exception.ZeroLengthArrayException;

public class ArrayService {

    /**
     * @param array in which prime numbers will be search
     * @return all prime numbers as Array
     * @throws ArrayIsNullRuntimeException if array is null
     */
    public Array getAllPrimeNumbers(Array array) throws ArrayIsNullRuntimeException {
        checkArray(array);

        int[] result = new int[array.size()];

        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (isPrime(array.get(i))) {
                result[count++] = array.get(i);
            }
        }

        return new Array(result, count);
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param array in which fibonacci numbers will be search
     * @return Array contains fibonacci numbers from specified array
     * @throws ArrayIsNullRuntimeException if array is null
     */
    public Array getAllFibonacciNumbers(Array array) throws ArrayIsNullRuntimeException {
        checkArray(array);

        if (array.size() == 0) {
            return new Array(0);
        }
        int[] result = new int[array.size()];
        int resultIndex = 0;

        for (int i = 0; i < array.size(); i++) {
            if (isNumberFib(array.get(i))) {
                result[resultIndex++] = array.get(i);
            }
        }

        return new Array(result, resultIndex);
    }

    private boolean isNumberFib(int num) {
        if (num < 1) {
            return false;
        }
        int t1 = 1;
        int t2 = 1;
        while (t2 < num) {
            int temp = t2;
            t2 += t1;
            t1 = temp;
        }
        return t2 == num;

    }

    /**
     *
     * @param array specified array
     * @return Array contains 3-sign numbers with not equals signs from specified array
     * @throws ArrayIsNullRuntimeException if array is null
     */
    public Array getAllThreeSignNumbersWithNoEqualsSign(Array array) throws ArrayIsNullRuntimeException {
        checkArray(array);

        int[] temp = new int[array.size()];
        int tempIndex = 0;
        for (int i = 0; i < array.size(); i++) {
            if (isNumberThreeSignAndWithNoEqualsSigns(array.get(i))) {
                temp[tempIndex++] = array.get(i);
            }
        }
        return new Array(temp, tempIndex);
    }

    private boolean isNumberThreeSignAndWithNoEqualsSigns(int num) {
        int[] signs = new int[10];
        int count = (int)Math.log10(num) + 1;
        if (count != 3) {
            return false;
        }
        for(int i = 0; i < count; i++) {
            int n = num % 10;
            signs[n]++;
            if (signs[n] > 1) {
                return false;
            }
            num = num / 10;
        }
        return true;
    }

    /**
     *
     * @param array in which max value would be searched
     * @return index of max value from arrays
     * @throws ZeroLengthArrayException if array size is 0
     * @throws ArrayIsNullRuntimeException if array is null
     */
    public int getMinOrMaxValueIndex(Array array, boolean isMinNeeded) throws ArrayIsNullRuntimeException, ZeroLengthArrayException {

        checkArray(array);

        if (array.size() == 0) {
            throw new ZeroLengthArrayException("array size is zero");
        }

        int valueIndex = 0;
        for (int i = 1 ; i < array.size(); i++) {
            if (isMinNeeded) {
                if (array.get(i) < array.get(valueIndex)) {
                    valueIndex = i;
                }
            } else {
                if (array.get(i) > array.get(valueIndex)) {
                    valueIndex = i;
                }
            }
        }
        return valueIndex;
    }

    private void checkArray(Array array) throws ArrayIsNullRuntimeException {
        if (array == null) {
            throw new ArrayIsNullRuntimeException("Array is null");
        }
    }

}
