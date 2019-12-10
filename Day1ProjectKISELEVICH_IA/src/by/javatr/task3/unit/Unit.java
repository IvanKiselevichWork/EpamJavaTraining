package by.javatr.task3.unit;

public class Unit {
    public static double getAreaOfSquareInscribedInCircle(double circleDiameter) {
        return circleDiameter * circleDiameter / 2;
    }

    public static double getDiameterOfCircleInscribedInSquare(double squareArea) {
        return Math.sqrt(squareArea);
    }
}
