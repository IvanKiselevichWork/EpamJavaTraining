package by.javatr.task6.unit.test;

import by.javatr.task6.entity.Timestamp;
import by.javatr.task6.unit.Unit;
import by.javatr.task6.unit.exception.InvalidSecondException;
import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

/*
    Timestamp getTimestampFromSecond(int second) throws InvalidSecondException
*/
    @Test(expected = InvalidSecondException.class)
    public void getTimestampFromSecondTest1() throws InvalidSecondException {
        int second = -1;
        Unit.getTimestampFromSecond(second);
    }

    @Test(expected = InvalidSecondException.class)
    public void getTimestampFromSecondTest2() throws InvalidSecondException {
        int second = 0;
        Unit.getTimestampFromSecond(second);
    }

    @Test
    public void getTimestampFromSecondTest3() throws InvalidSecondException {
        int second = 1;
        Timestamp expected = new Timestamp(0, 0, 0);
        Timestamp result = Unit.getTimestampFromSecond(second);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getTimestampFromSecondTest4() throws InvalidSecondException {
        int second = 32453245;
        Timestamp expected = new Timestamp(9014, 47, 24);
        Timestamp result = Unit.getTimestampFromSecond(second);
        Assert.assertEquals(expected, result);
    }
}
