package by.javatr.finance.service.exception.user;

import by.javatr.finance.service.exception.AbstractServiceException;

public class IncorrectPasswordServiceException extends AbstractServiceException {
    public IncorrectPasswordServiceException() {
    }

    public IncorrectPasswordServiceException(String message) {
        super(message);
    }

    public IncorrectPasswordServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectPasswordServiceException(Throwable cause) {
        super(cause);
    }
}
