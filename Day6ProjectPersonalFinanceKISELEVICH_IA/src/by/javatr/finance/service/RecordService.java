package by.javatr.finance.service;

import by.javatr.finance.entity.Record;
import by.javatr.finance.service.exception.AbstractServiceException;

import java.util.List;

public interface RecordService {
    void addRecord(Record record) throws AbstractServiceException;
    void removeRecord(Record record) throws AbstractServiceException;
    List<Record> getAllRecords() throws AbstractServiceException;
}
