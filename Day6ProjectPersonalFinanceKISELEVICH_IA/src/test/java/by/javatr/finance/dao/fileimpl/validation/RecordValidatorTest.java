package by.javatr.finance.dao.fileimpl.validation;


import by.javatr.finance.bean.Record;
import by.javatr.finance.dao.exception.record.RecordDAOException;
import by.javatr.finance.dao.fileImpl.validation.RecordValidator;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class RecordValidatorTest {

    private final RecordValidator recordValidator = new RecordValidator();

    @Test
    public void checkValidRecordOK() throws RecordDAOException {
        Record record = new Record(
                1,
                "user",
                "cause",
                LocalDateTime.parse("2007-12-23T10:15:35"),
                42);
        recordValidator.check(record);
        Assert.assertTrue(true);
    }

    @Test(expected = RecordDAOException.class)
    public void checkInvalidRecordRecordDAOException() throws RecordDAOException {
        Record record = null;
        recordValidator.check(record);
        Assert.assertTrue(true);
    }

    @Test(expected = RecordDAOException.class)
    public void checkInvalidRecordUserRecordDAOException() throws RecordDAOException {
        Record record = new Record(
                1,
                null,
                "cause",
                LocalDateTime.parse("2007-12-23T10:15:35"),
                42);
        recordValidator.check(record);
        Assert.assertTrue(true);
    }

    @Test(expected = RecordDAOException.class)
    public void checkInvalidRecordCauseRecordDAOException() throws RecordDAOException {
        Record record = new Record(
                1,
                "user",
                null,
                LocalDateTime.parse("2007-12-23T10:15:35"),
                42);
        recordValidator.check(record);
        Assert.assertTrue(true);
    }

    @Test(expected = RecordDAOException.class)
    public void checkInvalidRecordDateRecordDAOException() throws RecordDAOException {
        Record record = new Record(
                1,
                "user",
                "cause",
                null,
                42);
        recordValidator.check(record);
        Assert.assertTrue(true);
    }
}
