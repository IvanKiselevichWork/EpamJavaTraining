package by.javatr.task1.entity.exception;

public abstract class AbstractArrayRuntimeException extends RuntimeException {
    public AbstractArrayRuntimeException() {
    }

    public AbstractArrayRuntimeException(String message) {
        super(message);
    }

    public AbstractArrayRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractArrayRuntimeException(Throwable cause) {
        super(cause);
    }
}
