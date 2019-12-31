package by.javatr.finance.service.exception.user;

import by.javatr.finance.service.exception.AbstractServiceException;

public class UserServiceException extends AbstractServiceException {
    public UserServiceException() {
    }

    public UserServiceException(String message) {
        super(message);
    }

    public UserServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserServiceException(Throwable cause) {
        super(cause);
    }
}
