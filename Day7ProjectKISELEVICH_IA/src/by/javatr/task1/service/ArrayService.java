package by.javatr.task1.service;

import by.javatr.task1.entity.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayService {

    /**
     * @param array in which prime numbers will be search
     * @return all prime numbers as Array
     */
    public Array getAllPrimeNumbers(Array array) {
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
     */
    public Array getAllFibonacciNumbers(Array array) {
        int max = array.get(array.getMaxValueIndex());
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

}
