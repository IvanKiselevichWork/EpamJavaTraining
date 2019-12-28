package by.javatr.finance.dao.fileImpl;

import by.javatr.finance.dao.RecordDAO;
import by.javatr.finance.dao.exception.AbstractDAOException;
import by.javatr.finance.dao.exception.record.*;
import by.javatr.finance.dao.fileImpl.validation.RecordValidator;
import by.javatr.finance.entity.Record;

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
    public final static String DATE_FORMAT = "dd-MM-yyyy hh:mm:ss";

    public final static int USER_ID_INDEX = 0;
    public final static int CAUSE_INDEX = 1;
    public final static int DATE_INDEX = 2;
    public final static int AMOUNT_INDEX = 3;

    private final static String EMPTY_STRING = "";

    private RecordValidator recordValidator;

    public FileRecordDAO() throws WriteRecordDAOException {
        try {
            Files.write(Paths.get(RECORDS_FILENAME), EMPTY_STRING.getBytes(), StandardOpenOption.APPEND);
            recordValidator = new RecordValidator();
        } catch (IOException e) {
            throw new WriteRecordDAOException(RecordDAOExceptionMessages.cantWriteRecord, e);
        }
    }

    @Override
    public void addRecord(Record record) throws WrongRecordCauseDAOException, WrongRecordDateDAOException, WriteRecordDAOException, WrongRecordDAOException {
        try {
            recordValidator.checkForNull(record);

            Files.write(Paths.get(RECORDS_FILENAME), convertRecordToString(record).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new WriteRecordDAOException(RecordDAOExceptionMessages.cantWriteRecord, e);
        }
    }

    @Override
    public void removeRecord(Record record) throws WrongRecordCauseDAOException, WrongRecordDateDAOException, RecordNotFoundDAOException, ReadRecordDAOException, WriteRecordDAOException, WrongRecordDAOException {
        recordValidator.checkForNull(record);

        List<Record> records = getAllRecords();

        try {
            if (records.remove(record)) {
                File source = new File(RECORDS_FILENAME);
                File backup = new File(RECORDS_BACKUP_FILENAME);
                if (!source.renameTo(backup)) {
                    throw new WriteRecordDAOException(RecordDAOExceptionMessages.cantWriteRecord);
                }

                Files.write(Paths.get(RECORDS_FILENAME), EMPTY_STRING.getBytes());

                for (Record record1 : records) {
                    addRecord(record1);
                }
            } else {
                throw new WriteRecordDAOException(RecordDAOExceptionMessages.cantWriteRecord);
            }
        } catch (IOException | SecurityException e) {
            File source = new File(RECORDS_FILENAME);
            File backup = new File(RECORDS_BACKUP_FILENAME);
            backup.renameTo(source);
            throw new WriteRecordDAOException(RecordDAOExceptionMessages.cantWriteRecord, e);
        }
    }

    @Override
    public List<Record> getRecordsByUserId(int userId) throws AbstractDAOException {
        //todo
        return null;
    }

    @Override
    public List<Record> getAllRecords() throws ReadRecordDAOException {
        List<Record> list = new ArrayList<>();
        try {
            List<String> recordStrings =  Files.readAllLines(Paths.get(RECORDS_FILENAME));
            for(String recordString : recordStrings) {
                Record record = convertStringToRecord(recordString);
                list.add(record);
            }
        } catch (IOException e) {
            throw new ReadRecordDAOException(RecordDAOExceptionMessages.cantReadRecord, e);
        } catch (ArrayIndexOutOfBoundsException
                | DateTimeParseException
                | NumberFormatException
                | NullPointerException e) {
            throw new ReadRecordDAOException(RecordDAOExceptionMessages.dataCorrupted, e);
        }
        return list;
    }

    private String convertRecordToString(Record record) {
        return record.getUserId() + DELIMITER
                + record.getCause() + DELIMITER
                + record.getDate() + DELIMITER
                + record.getAmount() + System.lineSeparator();
    }

    private Record convertStringToRecord(String string) throws ArrayIndexOutOfBoundsException, DateTimeParseException, NumberFormatException {
        String[] recordArray = string.split(DELIMITER);
        return new Record(Long.parseLong(recordArray[USER_ID_INDEX]),
                recordArray[CAUSE_INDEX],
                LocalDateTime.parse(recordArray[DATE_INDEX]),
                Double.parseDouble(recordArray[AMOUNT_INDEX]));
    }
}
