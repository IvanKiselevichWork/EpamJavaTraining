package by.javatr.task7.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.scanner.exception.DataNotFoundException;
import by.javatr.scanner.exception.DataSourceException;
import by.javatr.task7.unit.Unit;

/**
 * 7.  Даны две точки А(х1, у1) и В(х2, у2). Составить алгоритм, определяющий, которая из точек находится
 * ближе к началу координат. x y.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Input x1: ");
        double x1;
        try {
            x1 = CustomScanner.readDouble(System.in);
        } catch (DataNotFoundException | DataSourceException e) {
            System.out.println("Input error!");
            return;
        }

        System.out.println("Input y1: ");
        double y1;
        try {
            y1 = CustomScanner.readDouble(System.in);
        } catch (DataNotFoundException | DataSourceException e) {
            System.out.println("Input error!");
            return;
        }

        System.out.println("Input x2: ");
        double x2;
        try {
            x2 = CustomScanner.readDouble(System.in);
        } catch (DataNotFoundException | DataSourceException e) {
            System.out.println("Input error!");
            return;
        }

        System.out.println("Input y2: ");
        double y2;
        try {
            y2 = CustomScanner.readDouble(System.in);
        } catch (DataNotFoundException | DataSourceException e) {
            System.out.println("Input error!");
            return;
        }

        int pointNumber = Unit.getCenterNearestPoint(x1, y1, x2, y2);

        switch (pointNumber) {
            case 0:
                System.out.println("equal");
                break;
            case 1:
                System.out.println("point1");
                break;
            case 2:
                System.out.println("point2");
                break;
        }
    }
}
