package by.javatr.task1.entity.exception;

public class NegativeIndexRuntimeException extends AbstractArrayRuntimeException {
    public NegativeIndexRuntimeException() {
    }

    public NegativeIndexRuntimeException(String message) {
        super(message);
    }

    public NegativeIndexRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeIndexRuntimeException(Throwable cause) {
        super(cause);
    }
}
