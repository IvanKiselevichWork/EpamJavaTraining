package by.javatr.task1.entity.exception;

public class NegativeIndexException extends AbstractArrayException {
    public NegativeIndexException() {
    }

    public NegativeIndexException(String message) {
        super(message);
    }

    public NegativeIndexException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeIndexException(Throwable cause) {
        super(cause);
    }
}
