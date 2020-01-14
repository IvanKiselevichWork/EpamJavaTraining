package by.javatr.task1.entity.exception;

public class InvalidArgumentRuntimeException extends AbstractArrayRuntimeException {
    public InvalidArgumentRuntimeException() {
    }

    public InvalidArgumentRuntimeException(String message) {
        super(message);
    }

    public InvalidArgumentRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidArgumentRuntimeException(Throwable cause) {
        super(cause);
    }
}
