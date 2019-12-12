package by.javatr.task10.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.scanner.exception.CustomScannerException;
import by.javatr.task10.unit.Unit;

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

        //todo
        Unit.getValuesTable(a, b, h);
    }
}
