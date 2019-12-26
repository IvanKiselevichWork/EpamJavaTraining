package by.javatr.task10.unit.exception;

public class InvalidRangeException extends Exception {
    public InvalidRangeException() {
    }

    public InvalidRangeException(String message) {
        super(message);
    }

    public InvalidRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRangeException(Throwable cause) {
        super(cause);
    }
}
