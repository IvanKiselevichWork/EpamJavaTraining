package task8;

import by.javatr.task8.unit.Unit;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UnitTest {

    private static final double THRESHOLD = .0000001;

/*
    double funcF(double x)
    TESTS
*/
    @Test
    public void funcFTest1() {
        double x = 5.;
        double expected = -1.;
        double result = Unit.funcF(x);
        assertEquals(expected, result, THRESHOLD);
    }

    @Test
    public void funcFTest2() {
        double x = 1.;
        double expected = -0.2;
        double result = Unit.funcF(x);
        assertEquals(expected, result, THRESHOLD);
    }

    @Test
    public void funcFTest3() {
        double x = 0;
        double expected = -0.16666666;
        double result = Unit.funcF(x);
        assertEquals(expected, result, THRESHOLD);
    }

    @Test
    public void funcFTest4() {
        double x = -5.;
        double expected = -0.00763359;
        double result = Unit.funcF(x);
        assertEquals(expected, result, THRESHOLD);
    }

    @Test
    public void funcFTest5() {
        double x = 1.8171205928321396588912117563273;
        double result = Unit.funcF(x);
        assertTrue(Double.isInfinite(result));
    }
}
