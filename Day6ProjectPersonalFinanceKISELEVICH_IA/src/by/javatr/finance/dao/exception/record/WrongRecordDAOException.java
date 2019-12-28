package by.javatr.finance.dao.exception.record;

import by.javatr.finance.dao.exception.AbstractDAOException;

public class WrongRecordDAOException extends AbstractDAOException {
    public WrongRecordDAOException() {
    }

    public WrongRecordDAOException(String message) {
        super(message);
    }

    public WrongRecordDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongRecordDAOException(Throwable cause) {
        super(cause);
    }
}
