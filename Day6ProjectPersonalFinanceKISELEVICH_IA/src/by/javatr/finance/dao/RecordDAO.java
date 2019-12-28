package by.javatr.finance.dao;

import by.javatr.finance.dao.exception.AbstractDAOException;
import by.javatr.finance.entity.Record;

import java.util.List;

public interface RecordDAO {
    void addRecord(Record record) throws AbstractDAOException;
    void removeRecord(Record record) throws AbstractDAOException;
    //List<Record> getRecordsByUserId(int userId) throws AbstractDAOException;
    List<Record> getAllRecords() throws AbstractDAOException;
    //List<Record> getRecordsByUserIdAndPeriod(int userId, LocalDateTime from, LocalDateTime to) throws DAOException;
}
