package by.javatr.task1.service.exception;

public class AbstractArrayServiceException extends Exception {
    public AbstractArrayServiceException() {
    }

    public AbstractArrayServiceException(String message) {
        super(message);
    }

    public AbstractArrayServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractArrayServiceException(Throwable cause) {
        super(cause);
    }
}
