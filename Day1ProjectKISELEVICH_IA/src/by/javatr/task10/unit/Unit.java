package by.javatr.task10.unit;

import by.javatr.task10.unit.exception.InvalidRangeException;
import by.javatr.task10.unit.exception.InvalidStepException;

public class Unit {

    // removed only one unclear exception InvalidArgumentException
    // created 2 clear exceptions InvalidRangeException, InvalidStepException
    public static double[][] getValuesTable(double a, double b, double h) throws InvalidRangeException, InvalidStepException {
        if (b < a) {
            throw new InvalidRangeException("Invalid range, must be b > a ");
        }

        // according to https://en.wikipedia.org/wiki/Machine_epsilon
        // Math.ulp(b) because b >= a
        if (h < Math.ulp(b)) {
            throw new InvalidStepException("Invalid step, h must be increased");
        }

        int size = (int)((b - a)/h) + 1;
        double[][] table = new double[size][2];
        int index = 0;
        for (double x = a; x <= b; x += h) {
            // removed redundant double declaration
            table[index][0] = x;
            table[index++][1] = Unit.funcF(x);
            // removed redundant index++;
        }
        return table;
    }

    // method moved to end of file, because of convention (public methods first, then all private ones)
    private static double funcF(double x) {
        return Math.tan(x);
    }

}
