package by.javatr.task9.unit.exception;

public class InvalidRadiusException extends Exception {
    public InvalidRadiusException() {
    }

    public InvalidRadiusException(String message) {
        super(message);
    }

    public InvalidRadiusException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRadiusException(Throwable cause) {
        super(cause);
    }
}
