package by.javatr.task1.entity.exception;

public class InvalidCapacityException extends AbstractArrayException {
    public InvalidCapacityException() {
    }

    public InvalidCapacityException(String message) {
        super(message);
    }

    public InvalidCapacityException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCapacityException(Throwable cause) {
        super(cause);
    }
}
