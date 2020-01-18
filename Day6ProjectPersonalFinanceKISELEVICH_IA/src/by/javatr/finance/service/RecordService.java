package by.javatr.finance.service;

import by.javatr.finance.bean.Record;
import by.javatr.finance.service.exception.record.RecordServiceException;

import java.util.List;

public interface RecordService {
    Record addRecord(Record record) throws RecordServiceException;
    void removeRecord(int recordId) throws RecordServiceException;
    List<Record> getAllRecordsByLogin(String login) throws RecordServiceException;
}
