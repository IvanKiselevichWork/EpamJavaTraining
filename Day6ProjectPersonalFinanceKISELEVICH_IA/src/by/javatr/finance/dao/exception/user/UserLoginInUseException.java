package by.javatr.finance.dao.exception.user;

import by.javatr.finance.dao.exception.DAOException;

public class UserLoginInUseException extends DAOException {
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
