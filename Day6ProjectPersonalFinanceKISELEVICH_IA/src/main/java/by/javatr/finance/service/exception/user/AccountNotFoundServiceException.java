package main.java.by.javatr.finance.service.exception.user;

import main.java.by.javatr.finance.service.exception.AbstractServiceException;

public class AccountNotFoundServiceException extends AbstractServiceException {
    public AccountNotFoundServiceException() {
    }

    public AccountNotFoundServiceException(String message) {
        super(message);
    }

    public AccountNotFoundServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountNotFoundServiceException(Throwable cause) {
        super(cause);
    }
}
