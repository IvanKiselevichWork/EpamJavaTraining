package by.javatr.finance.service.exception;

public abstract class AbstractServiceException extends Exception {
    public AbstractServiceException() {
    }

    public AbstractServiceException(String message) {
        super(message);
    }

    public AbstractServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractServiceException(Throwable cause) {
        super(cause);
    }
}
