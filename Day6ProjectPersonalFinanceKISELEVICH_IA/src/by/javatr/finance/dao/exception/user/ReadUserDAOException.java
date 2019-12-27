package by.javatr.finance.dao.exception.user;

import by.javatr.finance.dao.exception.AbstractDAOException;

public class ReadUserDAOException extends AbstractDAOException {
    public ReadUserDAOException() {
    }

    public ReadUserDAOException(String message) {
        super(message);
    }

    public ReadUserDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReadUserDAOException(Throwable cause) {
        super(cause);
    }
}
