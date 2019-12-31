package by.javatr.finance.dao;

import by.javatr.finance.dao.exception.record.RecordDAOException;
import by.javatr.finance.entity.Record;

import java.util.List;

public interface RecordDAO {
    void addRecord(Record record) throws RecordDAOException;
    void removeRecord(Record record) throws RecordDAOException;
    //List<Record> getRecordsByUserId(int userId) throws AbstractDAOException;
    List<Record> getAllRecords() throws RecordDAOException;
    //List<Record> getRecordsByUserIdAndPeriod(int userId, LocalDateTime from, LocalDateTime to) throws DAOException;
}
