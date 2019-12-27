package by.javatr.finance.dao.exception.user;

import by.javatr.finance.dao.exception.AbstractDAOException;

public class WriteUserDAOException extends AbstractDAOException {
    public WriteUserDAOException() {
    }

    public WriteUserDAOException(String message) {
        super(message);
    }

    public WriteUserDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public WriteUserDAOException(Throwable cause) {
        super(cause);
    }
}
