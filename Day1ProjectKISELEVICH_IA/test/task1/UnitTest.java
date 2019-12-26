package task1;

import by.javatr.task1.unit.Unit;
import org.junit.Assert;
import org.junit.Test;

public class UnitTest {
/*
    getLastDigit(int number) TESTS
 */
    @Test
    public void getLastDigitTest1() {
        int number = -1;
        int expected = 1;
        int result = Unit.getLastDigit(number);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getLastDigitTest2() {
        int number = 0;
        int expected = 0;
        int result = Unit.getLastDigit(number);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getLastDigitTest3() {
        int number = 1;
        int expected = 1;
        int result = Unit.getLastDigit(number);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getLastDigitTest4() {
        int number = 12;
        int expected = 2;
        int result = Unit.getLastDigit(number);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getLastDigitTest5() {
        int number = -34534;
        int expected = 4;
        int result = Unit.getLastDigit(number);
        Assert.assertEquals(expected, result);
    }

/*
    getLastDigitOfSqr(int number) TESTS
 */
    @Test
    public void getLastDigitOfSqrTest1() {
        int number = -1;
        int expected = 1;
        int result = Unit.getLastDigitOfSqr(number);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getLastDigitOfSqrTest2() {
        int number = 0;
        int expected = 0;
        int result = Unit.getLastDigitOfSqr(number);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getLastDigitOfSqrTest3() {
        int number = 1;
        int expected = 1;
        int result = Unit.getLastDigitOfSqr(number);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getLastDigitOfSqrTest4() {
        int number = 12;
        int expected = 4;
        int result = Unit.getLastDigitOfSqr(number);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getLastDigitOfSqrTest5() {
        int number = -34534;
        int expected = 6;
        int result = Unit.getLastDigitOfSqr(number);
        Assert.assertEquals(expected, result);
    }
}
