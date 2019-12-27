package by.javatr.finance.dao.exception.record;

import by.javatr.finance.dao.exception.AbstractDAOException;

public class ReadRecordDAOException extends AbstractDAOException {
    public ReadRecordDAOException() {
    }

    public ReadRecordDAOException(String message) {
        super(message);
    }

    public ReadRecordDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReadRecordDAOException(Throwable cause) {
        super(cause);
    }
}
