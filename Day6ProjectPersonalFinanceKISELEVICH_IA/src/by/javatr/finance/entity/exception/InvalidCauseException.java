package by.javatr.finance.entity.exception;

public class InvalidCauseException extends Exception {
    public InvalidCauseException() {
    }

    public InvalidCauseException(String message) {
        super(message);
    }

    public InvalidCauseException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCauseException(Throwable cause) {
        super(cause);
    }
}
