package by.javatr.finance.service.exception.record;

import by.javatr.finance.service.exception.AbstractServiceException;

public class IncorrectDateServiceException extends AbstractServiceException {
    public IncorrectDateServiceException() {
    }

    public IncorrectDateServiceException(String message) {
        super(message);
    }

    public IncorrectDateServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectDateServiceException(Throwable cause) {
        super(cause);
    }
}
