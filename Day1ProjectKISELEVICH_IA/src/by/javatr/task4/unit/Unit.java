package by.javatr.task4.unit;

import by.javatr.task4.unit.exception.InvalidArrayException;

public class Unit {

    public static boolean isArrayHasTwoEvenNumbers(int[] numbers) throws InvalidArrayException {
        if (numbers == null || numbers.length == 0) {
            throw new InvalidArrayException("Invalid array, must be numbers != null and numbers.length > 0");
        }
        int result = 0;
        for (int number : numbers) {
            if((number % 2 == 0)) {
                result++;
                if (result >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}