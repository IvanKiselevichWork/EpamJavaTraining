package by.javatr.task9.unit.test;

import by.javatr.task9.unit.Unit;
import by.javatr.task9.unit.exception.InvalidRadiusException;

import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

    private static final double THRESHOLD = .0000001;

/*
    double calculateCircleCircumference(double R) throws InvalidRadiusException
    TESTS
*/
    @Test(expected = InvalidRadiusException.class)
    public void calculateCircleCircumferenceTest1() throws InvalidRadiusException {
        double r = -1;
        Unit.calculateCircleCircumference(r);
    }

    @Test
    public void calculateCircleCircumferenceTest2() throws InvalidRadiusException {
        double r = 0;
        double expected = 0;
        double result = Unit.calculateCircleCircumference(r);
        Assert.assertEquals(expected, result, THRESHOLD);
    }

    @Test
    public void calculateCircleCircumferenceTest3() throws InvalidRadiusException {
        double r = 1;
        double expected = Math.PI * r * 2.;
        double result = Unit.calculateCircleCircumference(r);
        Assert.assertEquals(expected, result, THRESHOLD);
    }

/*
    double calculateCircleArea(double R) throws InvalidRadiusException
    TESTS
*/
    @Test(expected = InvalidRadiusException.class)
    public void calculateCircleAreaTest1() throws InvalidRadiusException {
        double r = -1;
        Unit.calculateCircleArea(r);
    }

    @Test
    public void calculateCircleAreaTest2() throws InvalidRadiusException {
        double r = 0;
        double expected = 0;
        double result = Unit.calculateCircleArea(r);
        Assert.assertEquals(expected, result, THRESHOLD);
    }

    @Test
    public void calculateCircleAreaTest3() throws InvalidRadiusException {
        double r = 1;
        double expected = Math.PI;
        double result = Unit.calculateCircleArea(r);
        Assert.assertEquals(expected, result, THRESHOLD);
    }
}
