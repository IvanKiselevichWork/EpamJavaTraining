package by.javatr.task10.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.scanner.exception.CustomScannerException;
import by.javatr.task10.unit.Unit;
import by.javatr.task10.unit.exception.InvalidRangeException;
import by.javatr.task10.unit.exception.InvalidStepException;

/**
 * 10. Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом h. Результат
 * представить в виде таблицы, первый столбец которой – значения аргумента, второй - соответствующие
 * значения функции.
 * F(x) = tg(x)
 */
public class Main {
    public static void main(String[] args) {

        //created function readDouble, repetition removed
        double a = readDouble("Input a: ");
        double b = readDouble("Input b (> a): ");
        double h = readDouble("Input h: ");

        /*
        System.out.println("Input a: ");
        double a;
        try {
            a = CustomScanner.readDouble(System.in);
        } catch (CustomScannerException e) {
            System.out.println("Input error!");
            return;
        }

        double b;
        System.out.println("Input b (> a): ");
        try {
            b = CustomScanner.readDouble(System.in);
        } catch (CustomScannerException e) {
            System.out.println("Input error!");
            return;
        }

        double h;
        System.out.println("Input h (> 0): ");
        try {
            h = CustomScanner.readDouble(System.in);
        } catch (CustomScannerException e) {
            System.out.println("Input error!");
            return;
        }
        */
        double[][] table;
        try {
            table = Unit.getValuesTable(a, b, h);
        } catch (InvalidRangeException e) {
            System.out.println("Invalid range, change a or b!");
            return;
        } catch (InvalidStepException e) {
            System.out.println("Invalid step, change h!");
            return;
        }

        for (double[] values : table) {
            System.out.printf("%6.3f     %6.3f\n", values[0], values[1]);
        }
    }

    private static double readDouble(String message) {
        System.out.println(message);
        double x;
        try {
            x = CustomScanner.readDouble(System.in);
        } catch (CustomScannerException e) {
            System.out.println("Input error!");
            throw new RuntimeException(e);
        }
        return x;
    }
}
