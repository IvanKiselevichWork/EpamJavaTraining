package by.javatr.finance.dao.exception.user;

import by.javatr.finance.dao.exception.DAOException;

public class WrongUserLoginException extends DAOException {
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
