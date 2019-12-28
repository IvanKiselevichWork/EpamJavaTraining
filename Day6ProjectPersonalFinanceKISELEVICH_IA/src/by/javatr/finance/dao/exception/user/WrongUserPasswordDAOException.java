package by.javatr.finance.dao.exception.user;

import by.javatr.finance.dao.exception.AbstractDAOException;

public class WrongUserPasswordDAOException extends AbstractDAOException {
    public WrongUserPasswordDAOException() {
    }

    public WrongUserPasswordDAOException(String message) {
        super(message);
    }

    public WrongUserPasswordDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongUserPasswordDAOException(Throwable cause) {
        super(cause);
    }
}
