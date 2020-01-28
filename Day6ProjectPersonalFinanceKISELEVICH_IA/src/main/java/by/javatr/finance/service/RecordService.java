package main.java.by.javatr.finance.service;

import main.java.by.javatr.finance.bean.Record;
import main.java.by.javatr.finance.service.exception.record.RecordServiceException;

import java.util.List;

public interface RecordService {
    Record addRecord(Record record) throws RecordServiceException;
    void removeRecord(int recordId) throws RecordServiceException;
    List<Record> getAllRecordsByLogin(String login) throws RecordServiceException;
}
