package by.javatr.task8.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.scanner.exception.CustomScannerException;
import by.javatr.task8.unit.Unit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input x: ");
        double x;
        try {
            x = CustomScanner.readDouble(System.in);
        } catch (CustomScannerException e) {
            System.out.println("Input error!");
            return;
        }
        double f = Unit.funcF(x);
        System.out.println("F(x) = " + f);
    }
}
