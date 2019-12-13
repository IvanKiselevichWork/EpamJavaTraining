package by.javatr.task5.unit;

import by.javatr.task5.unit.exception.InvalidPerfectNumberException;

public class Unit {
    //todo test
    public static boolean isNumberPerfect(int number) throws InvalidPerfectNumberException {
        if (number < 1) {
            throw new InvalidPerfectNumberException("Invalid number argument, must be number >= 1");
        }
        int dividersSum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                dividersSum += i;
            }
        }

        return dividersSum == number;
    }
}
