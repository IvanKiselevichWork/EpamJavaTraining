package task4;

import by.javatr.task4.unit.Unit;
import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

/*
    boolean isArrayHasTwoEvenNumbers(int[] numbers) throws InvalidArrayException
    TESTS
*/
    @Test
    public void isArrayHasTwoEvenNumbersTest1() {
        int a = 4, b = 5, c = 6, d = 7;
        boolean expected = true;
        boolean result = Unit.isFourNumbersHaveAtLeastTwoEvenNumbers(a, b, c, d);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void isArrayHasTwoEvenNumbersTest2() {
        int a = 4, b = 5, c = 3, d = 7;
        boolean expected = false;
        boolean result = Unit.isFourNumbersHaveAtLeastTwoEvenNumbers(a, b, c, d);
        Assert.assertEquals(expected, result);
    }
}
