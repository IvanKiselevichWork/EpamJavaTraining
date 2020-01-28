package by.javatr.finance.dao.fileImpl;

import by.javatr.finance.dao.RecordDAO;
import by.javatr.finance.dao.exception.record.*;
import by.javatr.finance.dao.fileImpl.validation.RecordValidator;
import by.javatr.finance.bean.Record;
import by.javatr.finance.logger.Logger;

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

    public final static int RECORD_ID = 0;
    public final static int USER_LOGIN = 1;
    public final static int CAUSE_INDEX = 2;
    public final static int DATE_INDEX = 3;
    public final static int AMOUNT_INDEX = 4;

    private final RecordValidator recordValidator = new RecordValidator();
    private final Logger logger = Logger.getLogger(this.getClass());

    public FileRecordDAO() {

    }

    @Override
    public Record addRecord(Record record) throws RecordDAOException {
        try {
            recordValidator.check(record);

            int id = getNextId();
            record.setId(id);

            Files.write(Paths.get(RECORDS_FILENAME), convertRecordToString(record).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            return record;
        } catch (IOException e) {
            throw new RecordDAOException(RecordDAOExceptionMessages.cantWriteRecord, e);
        }
    }

    @Override
    public void removeRecord(int id) throws RecordDAOException {


        List<Record> records = getAllRecords();

        try {
            boolean removeResult = false;
            for (Record record : records) {
                if (record.getId() == id) {
                    removeResult = records.remove(record);
                    break;
                }
            }
            if (removeResult) {
                File source = new File(RECORDS_FILENAME);
                File backup = new File(RECORDS_BACKUP_FILENAME);

                // if backup exist - delete and then create new one, else - just create new one
                if(backup.exists()) {
                    if(!backup.delete()) {
                        throw new RecordDAOException(RecordDAOExceptionMessages.cantRemoveRecord);
                    }
                }

                if (source.exists() && !source.renameTo(backup)) {
                    throw new RecordDAOException(RecordDAOExceptionMessages.cantRemoveRecord);
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

            if (source.exists() && backup.exists()) {
                source.delete();
            }
            if (backup.exists()) {
                backup.renameTo(source);
            }

            throw new RecordDAOException(RecordDAOExceptionMessages.cantRemoveRecord, e);
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
        } catch (IOException | DateTimeParseException | NumberFormatException | NullPointerException e) {
            logger.error(e.getMessage());
            //throw new RecordDAOException(RecordDAOExceptionMessages.cantReadRecord, e);
            //throw new RecordDAOException(RecordDAOExceptionMessages.dataCorrupted, e);
        }

        return list;
    }

    private String convertRecordToString(Record record) {
        return record.getId() + DELIMITER
                + record.getUserLogin() + DELIMITER
                + record.getCause() + DELIMITER
                + record.getDate() + DELIMITER
                + record.getAmount() + System.lineSeparator();
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

    private int getNextId() throws IOException {
        File source = new File(RECORDS_FILENAME);
        int lastId;
        if (source.exists()) {
            List<String> recordStrings = Files.readAllLines(Paths.get(RECORDS_FILENAME));
            String[] lastRecord = recordStrings.get(recordStrings.size() - 1).split(DELIMITER);
            lastId = Integer.parseInt(lastRecord[RECORD_ID]);
        } else {
            lastId = -1;
        }
        return lastId + 1;
    }
}
