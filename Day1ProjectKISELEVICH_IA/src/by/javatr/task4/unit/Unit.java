package by.javatr.task4.unit;

public class Unit {

    public static boolean isFourNumbersHaveAtLeastTwoEvenNumbers(int a, int b, int c, int d) {

        int evenNumberCount = getOneIfEvenZeroIfNot(a) +
                getOneIfEvenZeroIfNot(b) +
                getOneIfEvenZeroIfNot(c) +
                getOneIfEvenZeroIfNot(d);

        return evenNumberCount >= 2;
    }

    private static int getOneIfEvenZeroIfNot(int number) {
        if (number % 2 == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
