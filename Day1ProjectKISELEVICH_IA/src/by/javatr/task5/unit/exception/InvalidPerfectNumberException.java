package by.javatr.task5.unit.exception;

public class InvalidPerfectNumberException extends Exception {
    public InvalidPerfectNumberException() {
    }

    public InvalidPerfectNumberException(String message) {
        super(message);
    }

    public InvalidPerfectNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPerfectNumberException(Throwable cause) {
        super(cause);
    }
}
