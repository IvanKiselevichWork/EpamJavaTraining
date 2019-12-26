package by.javatr.task3.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.scanner.exception.DataNotFoundException;
import by.javatr.scanner.exception.DataSourceException;
import by.javatr.task3.unit.Unit;
import by.javatr.task3.unit.exception.InvalidAreaException;
import by.javatr.task3.unit.exception.InvalidDiameterException;

/**
 * 3.  Окружность  вписана  в  квадрат  заданной  площади.  Найти  площадь  квадрата,  вписанного  в  эту
 * окружность. Во сколько раз площадь вписанного квадрата меньше площади заданного?
 */
public class Main {
    public static void main(String[] args) {
        double squareArea;
        System.out.println("Input square area: ");
        try {
            squareArea = CustomScanner.readDouble(System.in);
        } catch (DataNotFoundException | DataSourceException e) {
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
