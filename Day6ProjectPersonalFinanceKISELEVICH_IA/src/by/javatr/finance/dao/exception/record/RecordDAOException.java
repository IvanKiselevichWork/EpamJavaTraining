package by.javatr.finance.dao.exception.record;

import by.javatr.finance.dao.exception.AbstractDAOException;

public class RecordDAOException extends AbstractDAOException {
    public RecordDAOException() {
    }

    public RecordDAOException(String message) {
        super(message);
    }

    public RecordDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecordDAOException(Throwable cause) {
        super(cause);
    }
}
