package by.javatr.finance.service.exception.record;

import by.javatr.finance.service.exception.AbstractServiceException;

public class IncorrectCauseServiceException extends AbstractServiceException {
    public IncorrectCauseServiceException() {
    }

    public IncorrectCauseServiceException(String message) {
        super(message);
    }

    public IncorrectCauseServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectCauseServiceException(Throwable cause) {
        super(cause);
    }
}
