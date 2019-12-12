package by.javatr.task3.unit.exception;

public class InvalidDiameterException extends Exception {
    public InvalidDiameterException() {
    }

    public InvalidDiameterException(String message) {
        super(message);
    }

    public InvalidDiameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDiameterException(Throwable cause) {
        super(cause);
    }
}
