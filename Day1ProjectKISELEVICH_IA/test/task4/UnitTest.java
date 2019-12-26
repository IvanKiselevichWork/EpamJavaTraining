package task4;

import by.javatr.task4.unit.Unit;
import by.javatr.task4.unit.exception.InvalidArrayException;
import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

/*
    boolean isArrayHasTwoEvenNumbers(int[] numbers) throws InvalidArrayException
    TESTS
*/
    @Test
    public void isArrayHasTwoEvenNumbersTest1() throws InvalidArrayException {
        int[] numbers = {4, 5, 6, 7};
        boolean expected = true;
        boolean result = Unit.isArrayHasTwoEvenNumbers(numbers);
        Assert.assertEquals(expected, result);
    }

    @Test(expected = InvalidArrayException.class)
    public void isArrayHasTwoEvenNumbersTest2() throws InvalidArrayException {
        int[] numbers = null;
        Unit.isArrayHasTwoEvenNumbers(numbers);
    }

    @Test(expected = InvalidArrayException.class)
    public void isArrayHasTwoEvenNumbersTest3() throws InvalidArrayException {
        int[] numbers = {};
        Unit.isArrayHasTwoEvenNumbers(numbers);
    }

    @Test
    public void isArrayHasTwoEvenNumbersTest4() throws InvalidArrayException {
        int[] numbers = {4, 5, 3, 7};
        boolean expected = false;
        boolean result = Unit.isArrayHasTwoEvenNumbers(numbers);
        Assert.assertEquals(expected, result);
    }
}
