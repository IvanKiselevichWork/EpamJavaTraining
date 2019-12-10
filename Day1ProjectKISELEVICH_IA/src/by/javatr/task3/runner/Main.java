package by.javatr.task3.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.task3.unit.Unit;

import java.time.Year;

public class Main {
    public static void main(String[] args) {
        double squareArea = 0;
        do {
            System.out.println("Input square area: ");
            squareArea = CustomScanner.readDouble(System.in);
        }
        while(squareArea <= 0);

        double circleDiameter = Unit.getDiameterOfCircleInscribedInSquare(squareArea);
        double inscribedSquareArea = Unit.getAreaOfSquareInscribedInCircle(circleDiameter);
        System.out.println("Inscribed square area: " + inscribedSquareArea);
    }
}
