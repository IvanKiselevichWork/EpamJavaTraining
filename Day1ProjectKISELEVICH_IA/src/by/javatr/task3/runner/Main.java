package by.javatr.task3.runner;

import by.javatr.task3.unit.Unit;
import by.javatr.task3.unit.exception.InvalidAreaException;
import by.javatr.task3.unit.exception.InvalidDiameterException;
import by.javatr.view.View;

/**
 * 3.  Окружность  вписана  в  квадрат  заданной  площади.  Найти  площадь  квадрата,  вписанного  в  эту
 * окружность. Во сколько раз площадь вписанного квадрата меньше площади заданного?
 */
public class Main {
    public static void main(String[] args) {

        // changes:
        //  removed repetition

        /*
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
         */

        // fixed 3 try-catch to 1
        try {
            double squareArea = View.readDouble("Input square area: ");

            double circleDiameter = Unit.getDiameterOfCircleInscribedInSquare(squareArea);
            double inscribedSquareArea = Unit.getAreaOfSquareInscribedInCircle(circleDiameter);
            System.out.println("Inscribed square area: " + inscribedSquareArea);
        } catch (InvalidAreaException e) {
            System.out.println("Invalid area!");
        } catch (InvalidDiameterException e) {
            System.out.println("Invalid diameter!");
        }
    }
}
