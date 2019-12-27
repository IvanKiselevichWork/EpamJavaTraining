package by.javatr.finance.dao.exception.record;

import by.javatr.finance.dao.exception.AbstractDAOException;

public class WriteRecordDAOException extends AbstractDAOException {
    public WriteRecordDAOException() {
    }

    public WriteRecordDAOException(String message) {
        super(message);
    }

    public WriteRecordDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public WriteRecordDAOException(Throwable cause) {
        super(cause);
    }
}
