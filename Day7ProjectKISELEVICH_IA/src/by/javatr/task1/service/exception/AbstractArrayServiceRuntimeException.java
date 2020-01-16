package by.javatr.task1.service.exception;

public abstract class AbstractArrayServiceRuntimeException extends RuntimeException {
    public AbstractArrayServiceRuntimeException() {
    }

    public AbstractArrayServiceRuntimeException(String message) {
        super(message);
    }

    public AbstractArrayServiceRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractArrayServiceRuntimeException(Throwable cause) {
        super(cause);
    }
}
