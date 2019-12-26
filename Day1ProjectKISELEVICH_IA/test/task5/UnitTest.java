package task5;

import by.javatr.task5.unit.Unit;
import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

/*
    boolean isNumberPerfect(int number) TESTS
*/
    @Test
    public void isNumberPerfectTest1() {
        int number = 1;
        boolean expected = false;
        boolean result = Unit.isNumberPerfect(number);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void isNumberPerfectTest2() {
        int number = 2;
        boolean expected = false;
        boolean result = Unit.isNumberPerfect(number);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void isNumberPerfectTest3() {
        int number = -1;
        boolean expected = false;
        boolean result = Unit.isNumberPerfect(number);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void isNumberPerfectTest4() {
        int number = 6;
        boolean expected = true;
        boolean result = Unit.isNumberPerfect(number);
        Assert.assertEquals(expected, result);
    }
}
