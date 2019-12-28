package by.javatr.finance.dao.exception.user;

import by.javatr.finance.dao.exception.AbstractDAOException;

public class UserLoginInUseDAOException extends AbstractDAOException {
    public UserLoginInUseDAOException() {
    }

    public UserLoginInUseDAOException(String message) {
        super(message);
    }

    public UserLoginInUseDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserLoginInUseDAOException(Throwable cause) {
        super(cause);
    }
}
