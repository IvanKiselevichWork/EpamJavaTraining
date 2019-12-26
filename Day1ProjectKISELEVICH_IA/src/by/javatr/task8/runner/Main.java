package by.javatr.task8.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.scanner.exception.DataNotFoundException;
import by.javatr.scanner.exception.DataSourceException;
import by.javatr.task8.unit.Unit;

/**
 * 8.  Вычислить значение функции:
 *          -x^2 + 3x + 9, x >= 3
 * F(x) =
 *          1 / (x^3 - 6), x < 3
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Input x: ");
        double x;
        try {
            x = CustomScanner.readDouble(System.in);
        } catch (DataNotFoundException | DataSourceException e) {
            System.out.println("Input error!");
            return;
        }
        double f = Unit.funcF(x);
        System.out.println("F(x) = " + f);
    }
}
