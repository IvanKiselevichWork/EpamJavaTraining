package by.javatr.finance.dao.exception.user;

import by.javatr.finance.dao.exception.DAOException;

public class WrongUserPasswordException extends DAOException {
    public WrongUserPasswordException() {
    }

    public WrongUserPasswordException(String message) {
        super(message);
    }

    public WrongUserPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongUserPasswordException(Throwable cause) {
        super(cause);
    }
}
