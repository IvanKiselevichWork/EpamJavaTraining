package by.javatr.task7.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.task7.unit.Unit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input x1: ");
        double x1 = CustomScanner.readDouble(System.in);

        System.out.println("Input y1: ");
        double y1 = CustomScanner.readDouble(System.in);

        System.out.println("Input x2: ");
        double x2 = CustomScanner.readDouble(System.in);

        System.out.println("Input y2: ");
        double y2 = CustomScanner.readDouble(System.in);

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
