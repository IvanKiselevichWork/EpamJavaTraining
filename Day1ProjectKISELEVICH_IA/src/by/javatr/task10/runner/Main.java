package by.javatr.task10.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.task10.unit.Unit;

public class Main {
    public static void main(String[] args) {

        System.out.println("Input a: ");
        double a = CustomScanner.readDouble(System.in);

        double b;
        do {
            System.out.println("Input b (> a): ");
            b = CustomScanner.readDouble(System.in);
        } while (b <= a);

        double h;
        do {
            System.out.println("Input h (< b - a): ");
            h = CustomScanner.readDouble(System.in);
        } while (h >= (b - a));

        for (double x = a; x <= b; x += h) {
            double f = Unit.funcF(x);
            System.out.printf("%6.3f     %6.3f\n", x, f);
        }
    }
}
