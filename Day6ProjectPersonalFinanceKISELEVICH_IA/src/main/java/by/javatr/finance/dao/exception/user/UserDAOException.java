package main.java.by.javatr.finance.dao.exception.user;

import main.java.by.javatr.finance.dao.exception.AbstractDAOException;

public class UserDAOException extends AbstractDAOException {
    public UserDAOException() {
    }

    public UserDAOException(String message) {
        super(message);
    }

    public UserDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDAOException(Throwable cause) {
        super(cause);
    }
}
