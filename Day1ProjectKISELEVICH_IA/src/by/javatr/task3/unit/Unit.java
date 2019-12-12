package by.javatr.task3.unit;

import by.javatr.task3.unit.exception.InvalidAreaException;
import by.javatr.task3.unit.exception.InvalidDiameterException;

public class Unit {
    //todo test
    public static double getAreaOfSquareInscribedInCircle(double circleDiameter) throws InvalidDiameterException {
        if (circleDiameter < 0) {
            throw new InvalidDiameterException();
        }
        return circleDiameter * circleDiameter / 2;
    }

    //todo test
    public static double getDiameterOfCircleInscribedInSquare(double squareArea) throws InvalidAreaException{
        if (squareArea < 0) {
            throw new InvalidAreaException();
        }
        return Math.sqrt(squareArea);
    }
}
