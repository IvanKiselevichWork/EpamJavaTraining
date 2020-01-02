package by.javatr.finance.dao.fileImpl;

import by.javatr.finance.dao.RecordDAO;
import by.javatr.finance.dao.exception.record.*;
import by.javatr.finance.dao.fileImpl.validation.RecordValidator;
import by.javatr.finance.entity.Record;
import by.javatr.finance.entity.exception.RecordException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class FileRecordDAO implements RecordDAO {

    public final static String RECORDS_FILENAME = "records.txt";
    public final static String RECORDS_BACKUP_FILENAME = "records.txt_backup";
    public final static String DELIMITER = ";";

    public final static int USER_LOGIN = 0;
    public final static int CAUSE_INDEX = 1;
    public final static int DATE_INDEX = 2;
    public final static int AMOUNT_INDEX = 3;

    private final static RecordValidator recordValidator = new RecordValidator();

    public FileRecordDAO() {

    }

    @Override
    public void addRecord(Record record) throws RecordDAOException {
        try {
            recordValidator.checkForNull(record);

            Files.write(Paths.get(RECORDS_FILENAME), convertRecordToString(record).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RecordDAOException(RecordDAOExceptionMessages.cantWriteRecord, e);
        }
    }

    @Override
    public void removeRecord(Record record) throws RecordDAOException {
        recordValidator.checkForNull(record);

        List<Record> records = getAllRecords();

        try {
            if (records.remove(record)) {
                File source = new File(RECORDS_FILENAME);
                File backup = new File(RECORDS_BACKUP_FILENAME);
                if (!source.renameTo(backup)) {
                    throw new RecordDAOException(RecordDAOExceptionMessages.cantWriteRecord);
                }

                for (Record record1 : records) {
                    addRecord(record1);
                }
            } else {
                throw new RecordDAOException(RecordDAOExceptionMessages.recordNotFound);
            }
        } catch (SecurityException e) {
            File source = new File(RECORDS_FILENAME);
            File backup = new File(RECORDS_BACKUP_FILENAME);
            backup.renameTo(source);
            throw new RecordDAOException(RecordDAOExceptionMessages.cantWriteRecord, e);
        }
    }

    @Override
    public List<Record> getAllRecords() throws RecordDAOException {
        List<Record> list = new ArrayList<>();
        try {
            List<String> recordStrings =  Files.readAllLines(Paths.get(RECORDS_FILENAME));
            for(String recordString : recordStrings) {
                Record record = convertStringToRecord(recordString);
                list.add(record);
            }
        } catch (IOException e) {
            throw new RecordDAOException(RecordDAOExceptionMessages.cantReadRecord, e);
        } catch (DateTimeParseException // unchecked
                | NumberFormatException // unchecked
                | NullPointerException // unchecked
                | RecordException e) { // checked
            throw new RecordDAOException(RecordDAOExceptionMessages.dataCorrupted, e);
        }
        return list;
    }

    private String convertRecordToString(Record record) {
        return record.getUserLogin() + DELIMITER
                + record.getCause() + DELIMITER
                + record.getDate() + DELIMITER
                + record.getAmount() + System.lineSeparator();
    }

    private Record convertStringToRecord(String string) throws RecordDAOException, DateTimeParseException, NumberFormatException, RecordException {
        String[] recordArray = string.split(DELIMITER);
        if (recordArray.length < 4) {
            throw new RecordDAOException(RecordDAOExceptionMessages.dataCorrupted);
        }
        return new Record(recordArray[USER_LOGIN],
                recordArray[CAUSE_INDEX],
                LocalDateTime.parse(recordArray[DATE_INDEX]),
                Double.parseDouble(recordArray[AMOUNT_INDEX]));
    }
}
