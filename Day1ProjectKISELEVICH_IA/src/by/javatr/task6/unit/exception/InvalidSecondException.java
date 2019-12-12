package by.javatr.task6.unit.exception;

public class InvalidSecondException extends Exception {
    public InvalidSecondException() {
    }

    public InvalidSecondException(String message) {
        super(message);
    }

    public InvalidSecondException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSecondException(Throwable cause) {
        super(cause);
    }
}
