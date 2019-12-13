package by.javatr.task3.unit;

import by.javatr.task3.unit.exception.InvalidAreaException;
import by.javatr.task3.unit.exception.InvalidDiameterException;

public class Unit {

    public static double getAreaOfSquareInscribedInCircle(double circleDiameter) throws InvalidDiameterException {
        if (circleDiameter < 0) {
            throw new InvalidDiameterException("Invalid circle diameter, must be >= 0");
        }
        return circleDiameter * circleDiameter / 2;
    }

    public static double getDiameterOfCircleInscribedInSquare(double squareArea) throws InvalidAreaException {
        if (squareArea < 0) {
            throw new InvalidAreaException("Invalid square area, must be >= 0");
        }
        return Math.sqrt(squareArea);
    }
}
