package by.javatr.task1.service;

import by.javatr.task1.entity.Array;

public class ArrayService {

    /**
     *
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

}
