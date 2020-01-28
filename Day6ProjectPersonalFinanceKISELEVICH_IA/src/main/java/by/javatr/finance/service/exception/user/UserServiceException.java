package main.java.by.javatr.finance.service.exception.user;

import main.java.by.javatr.finance.service.exception.AbstractServiceException;

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
