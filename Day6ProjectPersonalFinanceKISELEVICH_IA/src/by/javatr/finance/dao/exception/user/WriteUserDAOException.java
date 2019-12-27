package by.javatr.finance.dao.exception.user;

import by.javatr.finance.dao.exception.DAOException;

public class WriteUserDAOException extends DAOException {
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
