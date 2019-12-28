package by.javatr.finance.service.exception.record;

import by.javatr.finance.service.exception.AbstractServiceException;

public class IncorrectRecordServiceException extends AbstractServiceException {

    public IncorrectRecordServiceException() {
    }

    public IncorrectRecordServiceException(String message) {
        super(message);
    }

    public IncorrectRecordServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectRecordServiceException(Throwable cause) {
        super(cause);
    }
}
