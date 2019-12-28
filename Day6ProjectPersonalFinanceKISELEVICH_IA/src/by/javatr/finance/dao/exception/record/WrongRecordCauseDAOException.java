package by.javatr.finance.dao.exception.record;

import by.javatr.finance.dao.exception.AbstractDAOException;

public class WrongRecordCauseDAOException extends AbstractDAOException {
    public WrongRecordCauseDAOException() {
    }

    public WrongRecordCauseDAOException(String message) {
        super(message);
    }

    public WrongRecordCauseDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongRecordCauseDAOException(Throwable cause) {
        super(cause);
    }
}
