package task5;

import by.javatr.task5.unit.Unit;
import by.javatr.task5.unit.exception.InvalidPerfectNumberException;
import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

/*
    boolean isNumberPerfect(int number) throws InvalidPerfectNumberException
*/
    @Test
    public void isNumberPerfectTest1() throws InvalidPerfectNumberException {
        int number = 1;
        boolean expected = false;
        boolean result = Unit.isNumberPerfect(number);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void isNumberPerfectTest2() throws InvalidPerfectNumberException {
        int number = 2;
        boolean expected = false;
        boolean result = Unit.isNumberPerfect(number);
        Assert.assertEquals(expected, result);
    }

    @Test(expected = InvalidPerfectNumberException.class)
    public void isNumberPerfectTest3() throws InvalidPerfectNumberException {
        int number = 0;
        Unit.isNumberPerfect(number);
    }

    @Test(expected = InvalidPerfectNumberException.class)
    public void isNumberPerfectTest4() throws InvalidPerfectNumberException {
        int number = -1;
        Unit.isNumberPerfect(number);
    }

    @Test
    public void isNumberPerfectTest5() throws InvalidPerfectNumberException {
        int number = 6;
        boolean expected = true;
        boolean result = Unit.isNumberPerfect(number);
        Assert.assertEquals(expected, result);
    }
}
