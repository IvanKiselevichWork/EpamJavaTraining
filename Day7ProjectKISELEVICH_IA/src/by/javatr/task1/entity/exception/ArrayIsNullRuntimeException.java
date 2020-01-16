package by.javatr.task1.entity.exception;

public class ArrayIsNullRuntimeException extends AbstractArrayRuntimeException {
    public ArrayIsNullRuntimeException() {
    }

    public ArrayIsNullRuntimeException(String message) {
        super(message);
    }

    public ArrayIsNullRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayIsNullRuntimeException(Throwable cause) {
        super(cause);
    }
}
