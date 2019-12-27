package by.javatr.finance.dao.fileImpl;

import by.javatr.finance.dao.RecordDAO;
import by.javatr.finance.dao.exception.AbstractDAOException;
import by.javatr.finance.dao.exception.record.RecordExceptionMessages;
import by.javatr.finance.dao.exception.record.WriteRecordDAOException;
import by.javatr.finance.dao.fileImpl.validation.RecordValidator;
import by.javatr.finance.entity.Record;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileRecordDAO implements RecordDAO {

    public final static String RECORDS_FILENAME = "records.txt";
    public final static String DELIMITER = ";";
    public final static String DATE_FORMAT = "dd-MM-yyyy hh:mm:ss";

    public final static int USER_ID_INDEX = 0;
    public final static int CAUSE_INDEX = 1;
    public final static int DATE_INDEX = 2;
    public final static int AMOUNT_INDEX = 3;

    private final static String EMPTY_STRING = "";

    private RecordValidator recordValidator;

    public FileRecordDAO() throws WriteRecordDAOException {
        try {
            Files.write(Paths.get(RECORDS_FILENAME), EMPTY_STRING.getBytes());
            recordValidator = new RecordValidator();
        } catch (IOException e) {
            throw new WriteRecordDAOException(RecordExceptionMessages.cantWriteRecord, e);
        }
    }

    @Override
    public void addRecord(Record record) throws AbstractDAOException {

    }

    @Override
    public void removeRecord(int recordId) throws AbstractDAOException {

    }

    @Override
    public List<Record> getRecordsByUserId(int userId) throws AbstractDAOException {
        return null;
    }
}
