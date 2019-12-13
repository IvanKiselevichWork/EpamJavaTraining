package by.javatr.task3.unit.test;

import by.javatr.task3.unit.Unit;
import by.javatr.task3.unit.exception.InvalidAreaException;
import by.javatr.task3.unit.exception.InvalidDiameterException;
import org.junit.Assert;
import org.junit.Test;

public class UnitTest {
    private static final double THRESHOLD = .0000001;
    
/*
    double getAreaOfSquareInscribedInCircleTest1() throws InvalidDiameterException
    TESTS
 */
    @Test
    public void getAreaOfSquareInscribedInCircleTest1() throws InvalidDiameterException {
        double circleDiameter = 4.;
        double expected = 8.;
        double result = Unit.getAreaOfSquareInscribedInCircle(circleDiameter);
        Assert.assertEquals(expected, result, THRESHOLD);
    }

    @Test(expected = InvalidDiameterException.class)
    public void getAreaOfSquareInscribedInCircleTest2() throws InvalidDiameterException {
        double circleDiameter = -5.;
        Unit.getAreaOfSquareInscribedInCircle(circleDiameter);
    }

    @Test
    public void getAreaOfSquareInscribedInCircleTest3() throws InvalidDiameterException {
        double circleDiameter = 5.;
        double expected = 12.5;
        double result = Unit.getAreaOfSquareInscribedInCircle(circleDiameter);
        Assert.assertEquals(expected, result, THRESHOLD);
    }

    @Test
    public void getAreaOfSquareInscribedInCircleTest4() throws InvalidDiameterException {
        double circleDiameter = 0;
        double expected = 0;
        double result = Unit.getAreaOfSquareInscribedInCircle(circleDiameter);
        Assert.assertEquals(expected, result, THRESHOLD);
    }

/*
    double getDiameterOfCircleInscribedInSquare(double squareArea) throws InvalidAreaException
    TESTS
 */
    @Test
    public void getDiameterOfCircleInscribedInSquareTest1() throws InvalidAreaException {
        double squareArea = 4.;
        double expected = 2.;
        double result = Unit.getDiameterOfCircleInscribedInSquare(squareArea);
        Assert.assertEquals(expected, result, THRESHOLD);
    }

    @Test(expected = InvalidAreaException.class)
    public void getDiameterOfCircleInscribedInSquareTest2() throws InvalidAreaException {
        double squareArea = -4.;
        Unit.getDiameterOfCircleInscribedInSquare(squareArea);
    }

    @Test
    public void getDiameterOfCircleInscribedInSquareTest3() throws InvalidAreaException {
        double squareArea = 5.;
        double expected = 2.236067978;
        double result = Unit.getDiameterOfCircleInscribedInSquare(squareArea);
        Assert.assertEquals(expected, result, THRESHOLD);
    }

    @Test
    public void getDiameterOfCircleInscribedInSquareTest4() throws InvalidAreaException {
        double squareArea = 0;
        double expected = 0;
        double result = Unit.getDiameterOfCircleInscribedInSquare(squareArea);
        Assert.assertEquals(expected, result, THRESHOLD);
    }
}
