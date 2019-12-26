package by.javatr.task10.runner;

import by.javatr.task10.unit.Unit;
import by.javatr.task10.unit.exception.InvalidRangeException;
import by.javatr.task10.unit.exception.InvalidStepException;
import by.javatr.view.View;

/**
 * 10. Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом h. Результат
 * представить в виде таблицы, первый столбец которой – значения аргумента, второй - соответствующие
 * значения функции.
 * F(x) = tg(x)
 */
public class Main {
    public static void main(String[] args) {

        // changes:
        //  created function readDouble, repetition removed
        double a = View.readDouble("Input a: ");
        double b = View.readDouble("Input b (> a): ");
        double h = View.readDouble("Input h: ");

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
        try {
            double[][] table = Unit.getValuesTable(a, b, h);

            for (double[] values : table) {
                System.out.printf("%6.3f     %6.3f\n", values[0], values[1]);
            }
        } catch (InvalidRangeException e) {
            System.out.println("Invalid range, change a or b!");
        } catch (InvalidStepException e) {
            System.out.println("Invalid step, change h!");
        }
    }
}
