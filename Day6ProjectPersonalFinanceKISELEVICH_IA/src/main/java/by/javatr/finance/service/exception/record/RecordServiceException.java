package main.java.by.javatr.finance.service.exception.record;

import main.java.by.javatr.finance.service.exception.AbstractServiceException;

public class RecordServiceException extends AbstractServiceException {
    public RecordServiceException() {
    }

    public RecordServiceException(String message) {
        super(message);
    }

    public RecordServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecordServiceException(Throwable cause) {
        super(cause);
    }
}
