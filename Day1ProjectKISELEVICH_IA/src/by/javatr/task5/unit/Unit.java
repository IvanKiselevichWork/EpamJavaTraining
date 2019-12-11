package by.javatr.task5.unit;

public class Unit {
    public static boolean isNumberPerfect(int number) {
        int dividersSum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                dividersSum += i;
            }
        }

        return dividersSum == number;
    }
}
