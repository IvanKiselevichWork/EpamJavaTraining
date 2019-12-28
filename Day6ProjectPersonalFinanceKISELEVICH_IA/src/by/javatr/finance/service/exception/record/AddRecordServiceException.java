package by.javatr.finance.service.exception.record;

import by.javatr.finance.service.exception.AbstractServiceException;

public class AddRecordServiceException extends AbstractServiceException {
    public AddRecordServiceException() {
    }

    public AddRecordServiceException(String message) {
        super(message);
    }

    public AddRecordServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddRecordServiceException(Throwable cause) {
        super(cause);
    }
}
