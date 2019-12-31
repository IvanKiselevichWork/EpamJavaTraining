package by.javatr.finance.service;

import by.javatr.finance.entity.Record;
import by.javatr.finance.service.exception.record.RecordServiceException;

import java.util.List;

public interface RecordService {
    void addRecord(Record record) throws RecordServiceException;
    void removeRecord(Record record) throws RecordServiceException;
    List<Record> getAllRecords() throws RecordServiceException;
}
