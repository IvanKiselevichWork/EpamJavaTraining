package by.javatr.finance.dao;

import by.javatr.finance.dao.exception.DAOException;
import by.javatr.finance.entity.Record;

import java.time.LocalDateTime;
import java.util.List;

public interface RecordDAO {
    void addRecord(Record record) throws DAOException; //(int userId, String cause, LocalDateTime date, double amount);
    void removeRecord(int recordId) throws DAOException;
    List<Record> getRecordsByUserId(int userId) throws DAOException;
    //List<Record> getRecordsByUserIdAndPeriod(int userId, LocalDateTime from, LocalDateTime to) throws DAOException;
}
