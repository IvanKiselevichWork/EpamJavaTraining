package by.javatr.finance.dao.fileImpl.validation;

import by.javatr.finance.dao.exception.record.RecordDAOExceptionMessages;
import by.javatr.finance.dao.exception.record.WrongRecordCauseDAOException;
import by.javatr.finance.dao.exception.record.WrongRecordDateDAOException;
import by.javatr.finance.dao.exception.record.WrongRecordDAOException;
import by.javatr.finance.entity.Record;

public class RecordValidator {

    public RecordValidator() {

    }

    public void checkForNull(Record record) throws WrongRecordCauseDAOException, WrongRecordDateDAOException, WrongRecordDAOException {
        if (record == null) {
            throw new WrongRecordDAOException(RecordDAOExceptionMessages.recordIsNull);
        }

        if (record.getCause() == null) {
            throw new WrongRecordCauseDAOException(RecordDAOExceptionMessages.causeIsNull);
        }
        if (record.getDate() == null) {
            throw new WrongRecordDateDAOException(RecordDAOExceptionMessages.dateIsNull);
        }
    }

}
