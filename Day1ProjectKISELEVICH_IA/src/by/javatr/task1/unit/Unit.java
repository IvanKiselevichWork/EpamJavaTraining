package by.javatr.task1.unit;

public class Unit {

    public static int getLastDigit(int number) {
        return (number % 10);
    }

    public static int getLastDigitOfSqr(int number) {
        return ((number * number) % 10);
    }
}
