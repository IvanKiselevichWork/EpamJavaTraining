package by.javatr.task1.entity.exception;

public class NegativeLengthException extends AbstractArrayException {
    public NegativeLengthException() {
    }

    public NegativeLengthException(String message) {
        super(message);
    }

    public NegativeLengthException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeLengthException(Throwable cause) {
        super(cause);
    }
}
