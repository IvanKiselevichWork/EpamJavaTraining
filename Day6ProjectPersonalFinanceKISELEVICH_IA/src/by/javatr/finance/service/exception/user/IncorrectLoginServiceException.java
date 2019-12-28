package by.javatr.finance.service.exception.user;

import by.javatr.finance.service.exception.AbstractServiceException;

public class IncorrectLoginServiceException extends AbstractServiceException {
    public IncorrectLoginServiceException() {
    }

    public IncorrectLoginServiceException(String message) {
        super(message);
    }

    public IncorrectLoginServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectLoginServiceException(Throwable cause) {
        super(cause);
    }
}
