package by.javatr.task3.service.exception;

public abstract class AbstractTextServiceRuntimeException extends RuntimeException {
    public AbstractTextServiceRuntimeException() {
    }

    public AbstractTextServiceRuntimeException(String message) {
        super(message);
    }

    public AbstractTextServiceRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractTextServiceRuntimeException(Throwable cause) {
        super(cause);
    }
}
