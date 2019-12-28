package by.javatr.finance.service.exception.record;

import by.javatr.finance.service.exception.AbstractServiceException;

public class RemoveRecordServiceException extends AbstractServiceException {
    public RemoveRecordServiceException() {
    }

    public RemoveRecordServiceException(String message) {
        super(message);
    }

    public RemoveRecordServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public RemoveRecordServiceException(Throwable cause) {
        super(cause);
    }
}
