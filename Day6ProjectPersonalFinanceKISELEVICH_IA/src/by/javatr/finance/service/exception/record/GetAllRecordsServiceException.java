package by.javatr.finance.service.exception.record;

import by.javatr.finance.service.exception.AbstractServiceException;

public class GetAllRecordsServiceException extends AbstractServiceException {
    public GetAllRecordsServiceException() {
    }

    public GetAllRecordsServiceException(String message) {
        super(message);
    }

    public GetAllRecordsServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public GetAllRecordsServiceException(Throwable cause) {
        super(cause);
    }
}
