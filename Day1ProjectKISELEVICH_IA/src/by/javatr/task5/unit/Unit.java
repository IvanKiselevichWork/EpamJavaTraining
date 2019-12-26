package by.javatr.task5.unit;

//import by.javatr.task5.unit.exception.InvalidPerfectNumberException;

public class Unit {

    // changes:
    //  removed redundant exception
    public static boolean isNumberPerfect(int number) {
        if (number < 6) {
            return false;
            //throw new InvalidPerfectNumberException("Wrong number!");
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
