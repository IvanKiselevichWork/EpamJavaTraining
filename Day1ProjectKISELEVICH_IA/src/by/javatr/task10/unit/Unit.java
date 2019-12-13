package by.javatr.task10.unit;

import by.javatr.task10.unit.exception.InvalidArgumentsException;

public class Unit {

    private static double funcF(double x) {
        return Math.tan(x);
    }

    //todo test
    public static double[][] getValuesTable(double a, double b, double h) throws InvalidArgumentsException {
        if (b < a || h <= 0) {
            throw new InvalidArgumentsException("Invalid arguments, must be b > a and h > 0");
        }
        int size = (int)((b - a)/h) + 1;
        double[][] table = new double[size][2];
        int index = 0;
        for (double x = a; x <= b; x += h) {
            double f = Unit.funcF(x);
            table[index][0] = x;
            table[index][1] = f;
            index++;
        }
        return table;
    }
}
