package by.javatr.finance.service.impl.Validation;

import by.javatr.finance.entity.Record;
import by.javatr.finance.service.exception.record.IncorrectCauseServiceException;
import by.javatr.finance.service.exception.record.IncorrectDateServiceException;
import by.javatr.finance.service.exception.record.IncorrectRecordServiceException;
import by.javatr.finance.service.exception.record.RecordServiceExceptionMessages;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class RecordValidator {

    public void checkDate(LocalDateTime date) throws IncorrectDateServiceException {
        if(date == null) {
            throw new IncorrectDateServiceException(RecordServiceExceptionMessages.dateIsNull);
        }
    }

    public void checkCause(String cause) throws IncorrectCauseServiceException {
        if(cause == null) {
            throw new IncorrectCauseServiceException(RecordServiceExceptionMessages.causeIsNull);
        }
    }

    public void checkDate(String date) throws IncorrectDateServiceException {
        if(date == null) {
            throw new IncorrectDateServiceException(RecordServiceExceptionMessages.dateIsNull);
        }
        try {
            LocalDateTime.parse(date);
        } catch (DateTimeParseException e) {
            throw new IncorrectDateServiceException(RecordServiceExceptionMessages.incorrectDateFormat, e);
        }
    }

    public void checkRecord(Record record) throws IncorrectCauseServiceException, IncorrectDateServiceException, IncorrectRecordServiceException {
        if (record == null) {
            throw new IncorrectRecordServiceException(RecordServiceExceptionMessages.recordIsNull);
        }
        checkCause(record.getCause());
        checkDate(record.getDate());
    }
}
