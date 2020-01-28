package main.java.by.javatr.finance.dao.fileImpl.validation;

import main.java.by.javatr.finance.dao.exception.record.RecordDAOExceptionMessages;
import main.java.by.javatr.finance.dao.exception.record.RecordDAOException;
import main.java.by.javatr.finance.bean.Record;

public class RecordValidator {

    public RecordValidator() {

    }

    public void check(Record record) throws RecordDAOException {
        if (record == null) {
            throw new RecordDAOException(RecordDAOExceptionMessages.recordIsNull);
        }


        if (record.getUserLogin() == null) {
            throw new RecordDAOException(RecordDAOExceptionMessages.loginIsNull);
        }
        if (record.getCause() == null) {
            throw new RecordDAOException(RecordDAOExceptionMessages.causeIsNull);
        }
        if (record.getDate() == null) {
            throw new RecordDAOException(RecordDAOExceptionMessages.dateIsNull);
        }
    }

}
