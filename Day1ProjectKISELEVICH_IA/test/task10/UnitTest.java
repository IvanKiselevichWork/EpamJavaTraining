package task10;

import by.javatr.task10.unit.Unit;
import by.javatr.task10.unit.exception.InvalidRangeException;

import by.javatr.task10.unit.exception.InvalidStepException;
import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

    private static final double THRESHOLD = .0000001;

/*
    double[][] getValuesTable(double a, double b, double h) throws InvalidArgumentsException
    TESTS
*/
// todo tests naming
    @Test(expected = InvalidRangeException.class)
    public void getValuesTableTest1() throws InvalidRangeException, InvalidStepException {
        double a = 1;
        double b = 2;
        double h = -1;
        Unit.getValuesTable(a, b, h);
    }

    @Test(expected = InvalidRangeException.class)
    public void getValuesTableTest2() throws InvalidRangeException, InvalidStepException {
        double a = 1;
        double b = 2;
        double h = 0;
        Unit.getValuesTable(a, b, h);
    }

    @Test
    public void getValuesTableTest3() throws InvalidRangeException, InvalidStepException {
        double a = 1;
        double b = 2;
        double h = 0.5;
        double[][] expected = { {1, 1.5574077}, {1.5, 14.1014199}, {2, -2.185039863}};
        double[][] result = Unit.getValuesTable(a, b, h);
        if (expected.length != result.length) {
            Assert.fail();
        }
        for (int i = 0; i < 3; i++) {
            Assert.assertEquals(expected[i][0], result[i][0], THRESHOLD);
            Assert.assertEquals(expected[i][1], result[i][1], THRESHOLD);
        }
    }

    @Test
    public void getValuesTableTest4() throws InvalidRangeException, InvalidStepException {
        double a = 1;
        double b = 1;
        double h = 1;
        double[][] expected = { {1, 1.5574077} };
        double[][] result = Unit.getValuesTable(a, b, h);
        if (expected.length != result.length) {
            Assert.fail();
        }
        Assert.assertEquals(expected[0][0], result[0][0], THRESHOLD);
        Assert.assertEquals(expected[0][1], result[0][1], THRESHOLD);
    }

    @Test(expected = InvalidRangeException.class)
    public void getValuesTableTest5() throws InvalidRangeException, InvalidStepException {
        double a = 2;
        double b = 1;
        double h = 1;
        Unit.getValuesTable(a, b, h);
    }

}
