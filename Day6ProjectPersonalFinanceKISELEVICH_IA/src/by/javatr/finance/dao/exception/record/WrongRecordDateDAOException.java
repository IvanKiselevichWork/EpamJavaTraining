package by.javatr.finance.dao.exception.record;

import by.javatr.finance.dao.exception.AbstractDAOException;

public class WrongRecordDateDAOException extends AbstractDAOException {
    public WrongRecordDateDAOException() {
    }

    public WrongRecordDateDAOException(String message) {
        super(message);
    }

    public WrongRecordDateDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongRecordDateDAOException(Throwable cause) {
        super(cause);
    }
}
