package by.javatr.task1.entity.exception;

public class NegativeLengthRuntimeException extends AbstractArrayRuntimeException {
    public NegativeLengthRuntimeException() {
    }

    public NegativeLengthRuntimeException(String message) {
        super(message);
    }

    public NegativeLengthRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeLengthRuntimeException(Throwable cause) {
        super(cause);
    }
}
