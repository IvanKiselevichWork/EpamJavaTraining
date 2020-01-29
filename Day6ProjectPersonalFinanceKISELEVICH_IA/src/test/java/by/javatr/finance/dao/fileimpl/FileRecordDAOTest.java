package by.javatr.finance.dao.fileimpl;

import by.javatr.finance.bean.Record;
import by.javatr.finance.dao.exception.record.RecordDAOException;
import by.javatr.finance.dao.exception.record.RecordDAOExceptionMessages;
import by.javatr.finance.dao.fileImpl.FileRecordDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

import static by.javatr.finance.dao.fileImpl.FileRecordDAO.*;

public class FileRecordDAOTest {

    private final FileRecordDAO fileRecordDAO = new FileRecordDAO();

    @Before
    public void init() throws IOException {
        Files.write(Paths.get(RECORDS_FILENAME), "".getBytes());
    }

    private String convertRecordToString(Record record) {
        return record.getId() + DELIMITER
                + record.getUserLogin() + DELIMITER
                + record.getCause() + DELIMITER
                + record.getDate() + DELIMITER
                + record.getAmount();
    }

    private Record convertStringToRecord(String string) throws RecordDAOException, DateTimeParseException, NumberFormatException {
        String[] recordArray = string.split(DELIMITER);
        if (recordArray.length < 4) {
            throw new RecordDAOException(RecordDAOExceptionMessages.dataCorrupted);
        }
        return new Record(Integer.parseInt(recordArray[RECORD_ID]),
                recordArray[USER_LOGIN],
                recordArray[CAUSE_INDEX],
                LocalDateTime.parse(recordArray[DATE_INDEX]),
                Double.parseDouble(recordArray[AMOUNT_INDEX]));
    }

    @Test
    public void addRecordOK() throws RecordDAOException, IOException {

        Files.write(Paths.get(RECORDS_FILENAME), "".getBytes());

        Record record = new Record(
                1,
                "user",
                "cause",
                LocalDateTime.parse("2007-12-23T10:15:35"),
                42);
        record = fileRecordDAO.addRecord(record);

        List<String> listStr = Files.readAllLines(Paths.get(RECORDS_FILENAME));
        Files.write(Paths.get(RECORDS_FILENAME), "".getBytes());

        Assert.assertEquals(listStr.get(0), convertRecordToString(record));
    }

    @Test
    public void removeRecordOK() throws RecordDAOException, IOException {

        Files.write(Paths.get(RECORDS_FILENAME), "".getBytes());

        Record record1 = new Record(
                1,
                "user",
                "cause",
                LocalDateTime.parse("2007-12-23T10:15:35"),
                42);
        Record record2 = new Record(
                2,
                "user",
                "cause",
                LocalDateTime.parse("2009-12-23T10:15:35"),
                42);
        String recordStr = convertRecordToString(record1) + System.lineSeparator();
        Files.write(Paths.get(RECORDS_FILENAME), recordStr.getBytes());
        recordStr = convertRecordToString(record2) + System.lineSeparator();
        Files.write(Paths.get(RECORDS_FILENAME), recordStr.getBytes(), StandardOpenOption.APPEND);

        fileRecordDAO.removeRecord(1);

        List<String> listStr = Files.readAllLines(Paths.get(RECORDS_FILENAME));
        Files.write(Paths.get(RECORDS_FILENAME), "".getBytes());

        Assert.assertEquals(listStr.size(), 1);
        record1 = convertStringToRecord(listStr.get(0));
        record2.setId(0);

        Assert.assertEquals(record1, record2);
    }


    @Test
    public void getAllRecordsOK() throws RecordDAOException, IOException {

        Files.write(Paths.get(RECORDS_FILENAME), "".getBytes());

        Record record1 = new Record(
                1,
                "user",
                "cause",
                LocalDateTime.parse("2007-12-23T10:15:35"),
                42);
        Record record2 = new Record(
                2,
                "user",
                "cause",
                LocalDateTime.parse("2009-12-23T10:15:35"),
                42);
        String recordStr = convertRecordToString(record1) + System.lineSeparator();
        Files.write(Paths.get(RECORDS_FILENAME), recordStr.getBytes());
        recordStr = convertRecordToString(record2) + System.lineSeparator();
        Files.write(Paths.get(RECORDS_FILENAME), recordStr.getBytes(), StandardOpenOption.APPEND);

        List<Record> records = fileRecordDAO.getAllRecords();

        Assert.assertEquals(record1, records.get(0));
        Assert.assertEquals(record2, records.get(1));
    }
}
