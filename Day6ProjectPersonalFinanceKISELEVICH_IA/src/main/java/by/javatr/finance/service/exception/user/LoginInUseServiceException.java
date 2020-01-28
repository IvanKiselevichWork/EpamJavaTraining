package main.java.by.javatr.finance.service.exception.user;

import main.java.by.javatr.finance.service.exception.AbstractServiceException;

public class LoginInUseServiceException extends AbstractServiceException {
    public LoginInUseServiceException() {
    }

    public LoginInUseServiceException(String message) {
        super(message);
    }

    public LoginInUseServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginInUseServiceException(Throwable cause) {
        super(cause);
    }
}
