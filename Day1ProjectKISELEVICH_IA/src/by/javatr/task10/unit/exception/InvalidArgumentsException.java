package by.javatr.task10.unit.exception;

public class InvalidArgumentsException extends Exception {
    public InvalidArgumentsException() {
    }

    public InvalidArgumentsException(String message) {
        super(message);
    }

    public InvalidArgumentsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidArgumentsException(Throwable cause) {
        super(cause);
    }
}
