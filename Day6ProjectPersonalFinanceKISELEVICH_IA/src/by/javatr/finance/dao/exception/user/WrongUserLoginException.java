package by.javatr.finance.dao.exception.user;

import by.javatr.finance.dao.exception.AbstractDAOException;

public class WrongUserLoginException extends AbstractDAOException {
    public WrongUserLoginException() {
    }

    public WrongUserLoginException(String message) {
        super(message);
    }

    public WrongUserLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongUserLoginException(Throwable cause) {
        super(cause);
    }
}
