package by.javatr.task10.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.scanner.exception.CustomScannerException;
import by.javatr.task10.unit.Unit;

/**
 * 10. Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом h. Результат
 * представить в виде таблицы, первый столбец которой – значения аргумента, второй - соответствующие
 * значения функции.
 * F(x) = tg(x)
 */
public class Main {
    public static void main(String[] args) {

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
        System.out.println("Input h (< b - a): ");
        try {
            h = CustomScanner.readDouble(System.in);
        } catch (CustomScannerException e) {
            System.out.println("Input error!");
            return;
        }

        //todo MAX_PRIOR!!!!!!!!
        Unit.getValuesTable(a, b, h);
    }
}
