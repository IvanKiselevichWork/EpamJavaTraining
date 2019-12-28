package by.javatr.finance.dao.exception.user;

import by.javatr.finance.dao.exception.AbstractDAOException;

public class AccountNotFoundDAOException extends AbstractDAOException {
    public AccountNotFoundDAOException() {
    }

    public AccountNotFoundDAOException(String message) {
        super(message);
    }

    public AccountNotFoundDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountNotFoundDAOException(Throwable cause) {
        super(cause);
    }
}
