package by.javatr.finance.service.impl.validation;

import by.javatr.finance.bean.Record;
import by.javatr.finance.service.exception.record.RecordServiceException;
import by.javatr.finance.service.exception.record.RecordServiceExceptionMessages;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class RecordValidator {

    public void checkDate(LocalDateTime date) throws RecordServiceException {
        if(date == null) {
            throw new RecordServiceException(RecordServiceExceptionMessages.dateIsNull);
        }
    }

    public void checkCause(String cause) throws RecordServiceException {
        if(cause == null) {
            throw new RecordServiceException(RecordServiceExceptionMessages.causeIsNull);
        }
    }

    public void checkDate(String date) throws RecordServiceException {
        if(date == null) {
            throw new RecordServiceException(RecordServiceExceptionMessages.dateIsNull);
        }
        try {
            LocalDateTime.parse(date);
        } catch (DateTimeParseException e) {
            throw new RecordServiceException(RecordServiceExceptionMessages.incorrectDateFormat, e);
        }
    }

    public void checkRecord(Record record) throws RecordServiceException {
        if (record == null) {
            throw new RecordServiceException(RecordServiceExceptionMessages.recordIsNull);
        }
        checkCause(record.getCause());
        checkDate(record.getDate());
    }
}
