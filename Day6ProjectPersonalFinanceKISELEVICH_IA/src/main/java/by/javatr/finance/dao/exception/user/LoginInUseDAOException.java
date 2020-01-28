package main.java.by.javatr.finance.dao.exception.user;

import main.java.by.javatr.finance.dao.exception.AbstractDAOException;

public class LoginInUseDAOException extends AbstractDAOException {
    public LoginInUseDAOException() {
    }

    public LoginInUseDAOException(String message) {
        super(message);
    }

    public LoginInUseDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginInUseDAOException(Throwable cause) {
        super(cause);
    }
}
