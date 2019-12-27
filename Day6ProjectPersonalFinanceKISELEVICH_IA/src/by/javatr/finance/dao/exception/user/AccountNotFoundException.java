package by.javatr.finance.dao.exception.user;

import by.javatr.finance.dao.exception.AbstractDAOException;

public class AccountNotFoundException extends AbstractDAOException {
    public AccountNotFoundException() {
    }

    public AccountNotFoundException(String message) {
        super(message);
    }

    public AccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountNotFoundException(Throwable cause) {
        super(cause);
    }
}
