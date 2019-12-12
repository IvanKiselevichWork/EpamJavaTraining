package by.javatr.task3.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.scanner.exception.CustomScannerException;
import by.javatr.task3.unit.Unit;
import by.javatr.task3.unit.exception.InvalidAreaException;
import by.javatr.task3.unit.exception.InvalidDiameterException;

import java.time.Year;

public class Main {
    public static void main(String[] args) {
        double squareArea;
        System.out.println("Input square area: ");
        try {
            squareArea = CustomScanner.readDouble(System.in);
        } catch (CustomScannerException e) {
            System.out.println("Input error!");
            return;
        }

        double circleDiameter;
        try {
            circleDiameter = Unit.getDiameterOfCircleInscribedInSquare(squareArea);
        } catch (InvalidAreaException e) {
            System.out.println("Invalid area!");
            return;
        }

        double inscribedSquareArea;
        try {
            inscribedSquareArea = Unit.getAreaOfSquareInscribedInCircle(circleDiameter);
        } catch (InvalidDiameterException e) {
            System.out.println("Invalid diameter!");
            return;
        }

        System.out.println("Inscribed square area: " + inscribedSquareArea);
    }
}
