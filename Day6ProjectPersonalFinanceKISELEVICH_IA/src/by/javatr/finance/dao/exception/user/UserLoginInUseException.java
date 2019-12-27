package by.javatr.finance.dao.exception.user;

import by.javatr.finance.dao.exception.AbstractDAOException;

public class UserLoginInUseException extends AbstractDAOException {
    public UserLoginInUseException() {
    }

    public UserLoginInUseException(String message) {
        super(message);
    }

    public UserLoginInUseException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserLoginInUseException(Throwable cause) {
        super(cause);
    }
}
