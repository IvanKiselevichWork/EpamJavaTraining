package by.javatr.finance.dao.exception.user;

import by.javatr.finance.dao.exception.DAOException;

public class ReadUserDAOException extends DAOException {
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
