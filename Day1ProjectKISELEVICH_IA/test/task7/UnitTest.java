package task7;

import by.javatr.task7.unit.Unit;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UnitTest {

/*
    int getCenterNearestPoint(double x1, double y1, double x2, double y2)
    TESTS
*/
    @Test
    public void getCenterNearestPointTest1() {
        double x1 = 1, y1 = 2, x2 = 3, y2 = 4;
        int expected = 1;
        int result = Unit.getCenterNearestPoint(x1, y1, x2, y2);
        assertEquals(expected, result);
    }

    @Test
    public void getCenterNearestPointTest2() {
        double x1 = 56, y1 = 2, x2 = 3, y2 = 4;
        int expected = 2;
        int result = Unit.getCenterNearestPoint(x1, y1, x2, y2);
        assertEquals(expected, result);
    }

    @Test
    public void getCenterNearestPointTest3() {
        double x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        int expected = 0;
        int result = Unit.getCenterNearestPoint(x1, y1, x2, y2);
        assertEquals(expected, result);
    }

    @Test
    public void getCenterNearestPointTest4() {
        double x1 = 22, y1 = 22, x2 = 22, y2 = 22;
        int expected = 0;
        int result = Unit.getCenterNearestPoint(x1, y1, x2, y2);
        assertEquals(expected, result);
    }
}
