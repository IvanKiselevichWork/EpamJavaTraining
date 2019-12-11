package by.javatr.task9.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.task9.unit.Unit;

public class Main {
    public static void main(String[] args) {

        System.out.println("Input R: ");
        double R = CustomScanner.readDouble(System.in);

        double circumference = Unit.calculateCircleCircumference(R);
        double area = Unit.calculateCircleArea(R);

        System.out.println("Circle circumference = " + circumference);
        System.out.println("Circle area = " + area);
    }
}
