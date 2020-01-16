package by.javatr.task1.entity.exception;

public class NegativeCapacityRuntimeException extends AbstractArrayRuntimeException {
    public NegativeCapacityRuntimeException() {
    }

    public NegativeCapacityRuntimeException(String message) {
        super(message);
    }

    public NegativeCapacityRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeCapacityRuntimeException(Throwable cause) {
        super(cause);
    }
}
