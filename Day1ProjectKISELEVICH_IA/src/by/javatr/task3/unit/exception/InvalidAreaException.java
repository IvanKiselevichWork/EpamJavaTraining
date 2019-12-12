package by.javatr.task3.unit.exception;

public class InvalidAreaException extends Exception {
    public InvalidAreaException() {
    }

    public InvalidAreaException(String message) {
        super(message);
    }

    public InvalidAreaException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidAreaException(Throwable cause) {
        super(cause);
    }
}
