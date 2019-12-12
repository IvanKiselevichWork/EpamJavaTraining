package by.javatr.task9.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.scanner.exception.CustomScannerException;
import by.javatr.task9.unit.Unit;
import by.javatr.task9.unit.exception.InvalidRadiusException;

public class Main {
    public static void main(String[] args) {

        System.out.println("Input R: ");
        double R;
        try {
            R = CustomScanner.readDouble(System.in);
        } catch (CustomScannerException e) {
            System.out.println("Input error!");
            return;
        }

        double circumference;
        double area;
        try {
            circumference = Unit.calculateCircleCircumference(R);
            area = Unit.calculateCircleArea(R);
        } catch (InvalidRadiusException e) {
            System.out.println("Invalid radius");
            return;
        }

        System.out.println("Circle circumference = " + circumference);
        System.out.println("Circle area = " + area);
    }
}
