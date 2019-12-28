package by.javatr.finance.dao.exception.user;

import by.javatr.finance.dao.exception.AbstractDAOException;

public class WrongUserLoginDAOException extends AbstractDAOException {
    public WrongUserLoginDAOException() {
    }

    public WrongUserLoginDAOException(String message) {
        super(message);
    }

    public WrongUserLoginDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongUserLoginDAOException(Throwable cause) {
        super(cause);
    }
}
