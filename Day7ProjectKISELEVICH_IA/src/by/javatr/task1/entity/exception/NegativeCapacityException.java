package by.javatr.task1.entity.exception;

public class NegativeCapacityException extends AbstractArrayException {
    public NegativeCapacityException() {
    }

    public NegativeCapacityException(String message) {
        super(message);
    }

    public NegativeCapacityException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeCapacityException(Throwable cause) {
        super(cause);
    }
}
