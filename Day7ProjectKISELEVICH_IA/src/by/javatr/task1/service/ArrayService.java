package by.javatr.task1.service;

import by.javatr.task1.entity.Array;
import by.javatr.task1.service.exception.AbstractArrayServiceException;
import by.javatr.task1.service.exception.InvalidArrayException;
import by.javatr.task1.service.exception.InvalidArrayRuntimeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayService {

    /**
     * @param array in which prime numbers will be search
     * @return all prime numbers as Array
     */
    public Array getAllPrimeNumbers(Array array) {
        //todo array check
        int[] result = new int[array.size()];

        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (isPrime(array.get(i))) {
                result[count++] = array.get(i);
            }
        }

        Array resultArray = new Array(count);
        for (int i = 0; i < count; i++) {
            resultArray.set(i, result[i]);
        }
        return resultArray;
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
     * @throws InvalidArrayException if array size is 0
     * @throws InvalidArrayRuntimeException if array is null
     */
    public Array getAllFibonacciNumbers(Array array) throws InvalidArrayException {
        checkArray(array);

        int max = array.get(getMinOrMaxValueIndex(array, false));
        int[] fibNums = getFibonacciNumbers(max);
        int[] result = new int[array.size()];
        int resultIndex = 0;
        for (int i = 0; i < array.size(); i++) {
            for (int fibNum : fibNums) {
                if (array.get(i) == fibNum) {
                    result[resultIndex++] = fibNum;
                    break;
                }
            }
        }
        return new Array(Arrays.copyOf(result, resultIndex));
    }

    private int[] getFibonacciNumbers(int max) {
        if (max < 1) {
            return new int[] {0};
        }
        int n = 1;
        int oldN = 0;
        List<Integer> nums = new ArrayList<>();
        nums.add(oldN);
        while (n <= max) {
            nums.add(n);
            int temp = n;
            n = n + oldN;
            oldN = temp;
        }
        int[] result = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            result[i] = nums.get(i);
        }
        return result;
    }

    /**
     *
     * @param array specified array
     * @return Array contains 3-sign numbers with not equals signs from specified array
     */
    public Array getAllThreeSignNumbersWithNoEqualsSign(Array array) {
        //todo null
        int[] temp = new int[array.size()];
        int tempIndex = 0;
        for (int i = 0; i < array.size(); i++) {
            if (isNumberThreeSignAndWithNoEqualsSigns(array.get(i))) {
                temp[tempIndex++] = array.get(i);
            }
        }
        return new Array(Arrays.copyOf(temp, tempIndex));
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
     * @return index of max value from array
     * @throws InvalidArrayException if array size is 0
     * @throws InvalidArrayRuntimeException if array is null
     */
    public int getMinOrMaxValueIndex(Array array, boolean isMinNeeded) throws InvalidArrayException {
        checkArray(array);

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

    private void checkArray(Array array) throws InvalidArrayException {
        if (array == null) {
            throw new InvalidArrayRuntimeException("Array is null");
        }
        if (array.size() == 0) {
            throw new InvalidArrayException("Array size is 0");
        }
    }

}
