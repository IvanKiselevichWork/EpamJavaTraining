package task2;

import by.javatr.task2.unit.Unit;
import by.javatr.task2.unit.exception.InvalidMonthException;
import by.javatr.task2.unit.exception.InvalidYearException;
import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

/*
    int getDaysInMonth(int year, int month) throws InvalidYearException, InvalidMonthException
    TESTS
 */
    @Test
    public void getDaysInMonthTest1() throws InvalidYearException, InvalidMonthException {
        int year = 2019;
        int month = 12;
        int expected = 31;
        int result = Unit.getDaysInMonth(year, month);
        Assert.assertEquals(expected, result);
    }

    @Test(expected = InvalidYearException.class)
    public void getDaysInMonthTest2() throws InvalidYearException, InvalidMonthException {
        int year = Integer.MIN_VALUE;
        int month = 12;
        Unit.getDaysInMonth(year, month);
    }

    @Test(expected = InvalidYearException.class)
    public void getDaysInMonthTest3() throws InvalidYearException, InvalidMonthException {
        int year = Integer.MAX_VALUE;
        int month = 12;
        Unit.getDaysInMonth(year, month);
    }

    @Test(expected = InvalidMonthException.class)
    public void getDaysInMonthTest4() throws InvalidYearException, InvalidMonthException {
        int year = 2019;
        int month = -2;
        Unit.getDaysInMonth(year, month);
    }

    @Test(expected = InvalidMonthException.class)
    public void getDaysInMonthTest5() throws InvalidYearException, InvalidMonthException {
        int year = 2020;
        int month = 23;
        Unit.getDaysInMonth(year, month);
    }

/*
    boolean isYearLeap(int year) throws InvalidYearException
    TESTS
*/
    @Test
    public void isYearLeapTest1() throws InvalidYearException {
        int year = 2019;
        boolean result = Unit.isYearLeap(year);
        Assert.assertFalse(result);
    }

    @Test
    public void isYearLeapTest2() throws InvalidYearException {
        int year = 2020;
        boolean result = Unit.isYearLeap(year);
        Assert.assertTrue(result);
    }

    @Test(expected = InvalidYearException.class)
    public void isYearLeapTest3() throws InvalidYearException {
        int year = Integer.MIN_VALUE;
        boolean result = Unit.isYearLeap(year);
        Assert.assertTrue(result);
    }

    @Test(expected = InvalidYearException.class)
    public void isYearLeapTest4() throws InvalidYearException {
        int year = Integer.MAX_VALUE;
        boolean result = Unit.isYearLeap(year);
        Assert.assertTrue(result);
    }
}
